import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        for(int i=1; i<=K; i++) {
            int[] d = new int[D+1];
            d[1] = i;
            for(int j=i; j<=K; j++) {
                d[2] = j;
                for(int k=3; k<=D; k++) {
                    d[k] = d[k-2] + d[k-1];
                }
                if(d[D] == K) {
                    System.out.println(d[1]);
                    System.out.println(d[2]);
                    return;
                }
            }
        }
    }
}
