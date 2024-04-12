import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++) {
            q.offer(i);
        }

        StringBuffer sb = new StringBuffer();
        sb.append('<');
        for(int i=0; i<N; i++) {
            for(int j=0; j<K-1; j++) {
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if(i < N-1) {
                sb.append(", ");
            }
        }
        sb.append('>');
        System.out.println(sb);
    }
}