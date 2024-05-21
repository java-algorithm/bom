import java.io.*;
import java.util.*;

public class Main {

    public static List<List<int[]>> graph;
    public static int[] dist;
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        dist = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[]{B, C});
            graph.get(B).add(new int[]{A, C});
        }
        dijkstra();
    }

    public static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{1, 0});
        while(!pq.isEmpty()) {
            int v = pq.peek()[0];
            int cost = pq.peek()[1];
            pq.poll();

            // 중복 방문 방지
            if(dist[v] < cost) {
                continue;
            }

            List<int[]> list = graph.get(v);
            for(int i=0; i<list.size(); i++) {
                int nextV = list.get(i)[0];
                int nextCost = list.get(i)[1];
                if(dist[nextV] > cost + nextCost) {
                    dist[nextV] = cost + nextCost;
                    pq.offer(new int[]{nextV, dist[nextV]});
                }
            }
        }
        System.out.println(dist[N]);
    }
}
