import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int square = 1;
        while(square < K) {
            square *= 2;
            if(square == K) {
                System.out.println(square + " 0");
                return;
            }
        }
        int count = 0;
        int num = square;
        while(K >= 1) {
            num /= 2;
            if(num <= K) {
                K -= num;
            }
            count++;
        }
        System.out.println(square + " " + count);
    }
}