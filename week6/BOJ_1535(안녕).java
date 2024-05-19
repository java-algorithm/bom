import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hp = new int[N + 1];
        int[] happy = new int[N + 1];
        int[][] d = new int[N + 1][101];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            hp[i] = Integer.parseInt(st1.nextToken());
            happy[i] = Integer.parseInt(st2.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= 100; j++) {
                if (j - hp[i] > 0) {
                    d[i][j] = Math.max(d[i - 1][j], d[i - 1][j - hp[i]] + happy[i]);
                } else {
                    d[i][j] = d[i - 1][j];
                }
            }
        }
        System.out.println(d[N][100]);
    }
}
