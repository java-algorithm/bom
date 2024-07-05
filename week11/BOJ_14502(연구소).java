import java.io.*;
import java.util.*;

public class Main {

    private static int[][] virus;
    private static int N, M;
    private static List<int[]> space;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        virus = new int[N][M];
        space = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                virus[i][j] = Integer.parseInt(st.nextToken());
                if(virus[i][j] == 0) {
                    space.add(new int[]{i, j});
                }
            }
        }
        dfs(0, 0, new ArrayList<>());
        System.out.println(answer);
    }

    public static void dfs(int start, int index, List<int[]> wall) {
        if(index == 3) {
            answer = Math.max(answer, bfs(copyArr(), wall));
            return;
        }

        for(int i=start; i<space.size(); i++) {
            int h = space.get(i)[0];
            int w = space.get(i)[1];
            wall.add(new int[]{h, w});
            dfs(i+1, index+1, wall);
            wall.remove(index);
        }
    }

    public static int bfs(int[][] virus, List<int[]> wall) {
        int[] dh = {0, 1, 0, -1};
        int[] dw = {-1, 0, 1, 0};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        for(int i=0; i<3; i++) {
            virus[wall.get(i)[0]][wall.get(i)[1]] = 1;
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virus[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()) {
            int h = q.peek()[0];
            int w = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >= 0 && nextH < N && nextW >= 0 && nextW < M) {
                    if(!visited[nextH][nextW] && virus[nextH][nextW] == 0) {
                        visited[nextH][nextW] = true;
                        virus[nextH][nextW] = 2;
                        q.offer(new int[]{nextH, nextW});
                    }
                }
            }
        }
        return getSafeZone(virus);
    }

    public static int[][] copyArr() {
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++) {
            arr[i] = virus[i].clone();
        }
        return arr;
    }

    public static int getSafeZone(int[][] virus) {
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(virus[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
