import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            Deque<Integer> q = new LinkedList<>();
            q.add(arr[N-1]);
            for(int j=N-2; j>=1; j-=2) {
                q.addFirst(arr[j]);
                q.addLast(arr[j-1]);
            }
            if(N%2 == 0) {
                q.addFirst(arr[0]);
            }

            int answer = Math.abs(q.getFirst() - q.getLast());
            for(int j=0; j<N-1; j++) {
                int num = q.removeFirst();
                answer = Math.max(answer, Math.abs(num-q.getFirst()));
            }
            sb.append(answer).append('\n');
        }
        System.out.println(sb.toString());
    }
}