import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long[][] d = new long[N][N];
        d[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int jump = board[i][j];
                if (jump == 0) {
                    continue;
                }
                if (j + jump < N) {
                    d[i][j + jump] += d[i][j];
                }
                if (i + jump < N) {
                    d[i + jump][j] += d[i][j];
                }
            }
        }
        System.out.println(d[N - 1][N - 1]);
    }
}
