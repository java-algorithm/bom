import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        if(N == 1) {
            System.out.println("1");
        }else if(N == 2) {
            System.out.println(Math.min(4, (M+1)/2));
        }else {
            if(M <= 6) {
                System.out.println(Math.min(4, M));
            }else {
                System.out.println(M-2);
            }
        }
    }
}