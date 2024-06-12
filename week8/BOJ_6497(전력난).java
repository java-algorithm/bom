import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) {
                System.out.print(sb);
                return;
            }
            parent = new int[N + 1];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
            long totalCost = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                totalCost += C;
                pq.offer(new int[]{A, B, C});
            }
            long minCost = 0;
            while (!pq.isEmpty()) {
                int[] edge = pq.poll();
                int v1 = edge[0];
                int v2 = edge[1];
                int cost = edge[2];

                if (union(v1, v2)) {
                    minCost += cost;
                }
            }
            sb.append(totalCost - minCost).append('\n');
        }
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
