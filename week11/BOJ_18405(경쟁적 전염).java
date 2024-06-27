import java.io.*;
import java.util.*;

public class Main {

    private static int[][] virus;
    private static int N;
    private static PriorityQueue<int[]> q;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        virus = new int[N][N];
        q = new PriorityQueue<>((o1, o2) -> Integer.compare(virus[o1[0]][o1[1]], virus[o2[0]][o2[1]]));
        visited = new boolean[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                virus[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(virus[i][j] > 0 && !visited[i][j]) {
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        for(int i=0; i<S; i++) {
            bfs();
        }
        System.out.println(virus[X-1][Y-1]);
    }

    public static void bfs() {
        int[] dh = {0, 1, 0, -1};
        int[] dw = {-1, 0, 1, 0};
        List<int[]> nextVirus = new ArrayList<>();
        while(!q.isEmpty()) {
            int h = q.peek()[0];
            int w = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >= 0 && nextH < N && nextW >= 0 && nextW < N) {
                    if(!visited[nextH][nextW]) {
                        visited[nextH][nextW] = true;
                        virus[nextH][nextW] = virus[h][w];
                        nextVirus.add(new int[]{nextH, nextW});
                    }
                }
            }
        }
        for(int i=0; i<nextVirus.size(); i++) {
            q.offer(nextVirus.get(i));
        }
    }
}
