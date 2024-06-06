import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{A, B, C});
        }
        long totalCost = 0;
        int maxCost = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int v1 = edge[0];
            int v2 = edge[1];
            int cost = edge[2];

            // 사이클이 없으면 연결 후 비용 더하기
            if(union(v1, v2)) {
                totalCost += cost;
                maxCost = cost;
            }
        }
        System.out.println(totalCost - maxCost);
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
