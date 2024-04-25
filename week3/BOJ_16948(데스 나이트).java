import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        int[][] visited = new int[N+1][N+1];
        int[] dh = {-2, -2, 0, 0, 2, 2};
        int[] dw = {-1, 1, -2, 2, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r1, c1});
        while(!q.isEmpty()) {
            int h = q.peek()[0];
            int w = q.peek()[1];
            q.poll();
            if(h == r2 && w == c2) {
                System.out.println(visited[h][w]);
                return;
            }

            for(int i=0; i<6; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >= 0 && nextH < N && nextW >= 0 && nextW < N) {
                    if(visited[nextH][nextW] == 0) {
                        visited[nextH][nextW] = visited[h][w] + 1;
                        q.offer(new int[]{nextH, nextW});
                    }
                }
            }
        }
        System.out.println("-1");
    }
}