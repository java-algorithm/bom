import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;
    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        count = new int[N+1];
        for(int i=0; i<N; i++) {
            parent[i] = i;
            count[i] = 1;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int tutor = Integer.parseInt(st.nextToken());
            int tutee = Integer.parseInt(st.nextToken());
            union(tutor, tutee);
        }
        long answer = 1;
        for(int i=0; i<N; i++) {
            answer = (answer * count[i]) % 1000000007;
        }
        System.out.println(answer);
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return;
        }
        count[x] += count[y];
        count[y] = 1;
        parent[y] = x;
    }
}
