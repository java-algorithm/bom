import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] seat = new int[1000002];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            seat[start]++;
            seat[end+1]--;
        }
        for(int i=1; i<1000001; i++) {
            seat[i] += seat[i-1];
        }
        int Q = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<Q; i++) {
            int time = Integer.parseInt(st.nextToken());
            sb.append(seat[time]).append('\n');
        }
        System.out.print(sb);
    }
}
