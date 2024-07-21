import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] h = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        int[] arr = new int[N+2];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            arr[a] += k;
            arr[b+1] -= k;
        }
        for(int i=1; i<=N; i++) {
            arr[i] += arr[i-1];
            h[i] += arr[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(h[i]).append(' ');
        }
        System.out.println(sb);
    }
}