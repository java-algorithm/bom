package week3;

import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] shark;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        shark = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                shark[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(shark[i][j] == 0) {
                    max = Math.max(max, getSafeDistance(i, j));
                }
            }
        }
        System.out.println(max);
    }

    public static int getSafeDistance(int h, int w) {
        int[] dh = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dw = {-1, 0, 1, -1, 1, -1, 0, 1};

        int[][] visited = new int[N][M];
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{h, w});
        visited[h][w] = 1;
        while(!q.isEmpty()) {
            h = q.peek()[0];
            w = q.peek()[1];
            q.poll();

            for(int i=0; i<8; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >=0 && nextH < N && nextW >=0 && nextW < M) {
                    if(visited[nextH][nextW] == 0) {
                        if(shark[nextH][nextW] == 0) {
                            visited[nextH][nextW] = visited[h][w] + 1;
                            q.offer(new int[]{nextH, nextW});
                        }else {
                            min = Math.min(min, visited[h][w]);
                        }
                    }
                }
            }
        }
        return min;
    }
}