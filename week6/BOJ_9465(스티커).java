import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[3][N+1];
            for(int i=0; i<2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // d[0][i] = 윗줄 스티커만 뜯는 경우
            // d[1][i] = 아랫줄 스티커만 뜯는 경우
            // d[2][i] = 스티커를 떼지 않는 경우
            int[][] d = new int[3][N+1];
            d[0][0] = sticker[0][0];
            d[1][0] = sticker[1][0];
            for(int i=1; i<=N; i++) {
                d[0][i] = Math.max(d[1][i-1], d[2][i-1]) + sticker[0][i];
                d[1][i] = Math.max(d[0][i-1], d[2][i-1]) + sticker[1][i];
                d[2][i] = Math.max(d[0][i-1], Math.max(d[1][i-1], d[2][i-1]));
            }
            System.out.println(Math.max(d[0][N], d[1][N]));
        }
    }
}
