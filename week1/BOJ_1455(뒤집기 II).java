import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int N = Integer.parseInt(num[0]);
        int M = Integer.parseInt(num[1]);
        int[][] coin = new int[N][M];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                coin[i][j] = input.charAt(j) - '0';
            }
        }
        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            for (int j = M-1; j >= 0; j--) {
                if(coin[i][j] == 1) {
                    flipCoin(coin, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void flipCoin(int[][] coin, int a, int b) {
        for(int i=0; i<=a; i++) {
            for(int j=0; j<=b; j++) {
                if(coin[i][j] == 0) {
                    coin[i][j] = 1;
                }else {
                    coin[i][j] = 0;
                }
            }
        }
    }
}