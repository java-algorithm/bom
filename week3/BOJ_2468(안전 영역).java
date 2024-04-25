import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }
        int answer = 1;
        for(int k=1; k<=max; k++) {
            visited = new int[N+1][N+1];
            int count = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(visited[i][j] == 0 && map[i][j] > k) {
                        count++;
                        bfs(i, j, k, count);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    public static void bfs(int h, int w, int depth, int count) {
        int[] dh = {-1, 0, 1, 0};
        int[] dw = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{h, w});
        visited[h][w] = 1;
        while(!q.isEmpty()) {
            h = q.peek()[0];
            w = q.peek()[1];
            q.poll();

            for(int i=0; i<4; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >= 0 && nextH < N && nextW >= 0 && nextW < N) {
                    if(visited[nextH][nextW] == 0 && map[nextH][nextW] > depth) {
                        visited[nextH][nextW] = count;
                        q.offer(new int[]{nextH, nextW});
                    }
                }
            }
        }
    }
}
