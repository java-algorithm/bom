import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(0, 11);
        System.out.println("-1");
    }

    public static void dfs(long num, int index) {
        if(index == 0) {
            if(count == N) {
                System.out.println(num);
                System.exit(0);
            }
            count++;
            return;
        }
        long k = (num == 0) ? 10 : num % 10;
        for(long i=0; i<k; i++) {
            dfs(num*10 + i, index-1);
        }
    }
}
