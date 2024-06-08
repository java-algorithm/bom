import java.io.*;
import java.util.*;

public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for(int i=0; i<N; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if(i < j) {
                    pq.add(new int[]{i, j, cost});
                }
            }
        }

        long minCost = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];

            if(union(v1, v2)) {
                minCost += cost;
            }
        }
        System.out.println(minCost);
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return false;
        }
        parent[y] = x;
        return true;
    }
}
