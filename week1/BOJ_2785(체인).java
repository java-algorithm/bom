import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        int link = q.size() - 1;
        while(true) {
            int chain = q.peek();
            if(link > chain) {
                link -= chain + 1;
                count += q.poll();
            }else {
                count += link;
                break;
            }
        }
        System.out.println(count);
    }
}