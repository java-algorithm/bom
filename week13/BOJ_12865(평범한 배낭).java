import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // d[i][무게] = i번째 보급품에서의 최대 가치
        int[][] d = new int[N+1][K+1];
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            // 무게
            w[i] = Integer.parseInt(st.nextToken());
            // 가치
            v[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=K; j++) {
                if(j-w[i] >= 0) {
                    d[i][j] = Math.max(d[i-1][j], d[i-1][j-w[i]] + v[i]);
                }else {
                    d[i][j] = d[i-1][j];
                }
            }
        }
        System.out.println(d[N][K]);
    }
}
