import java.io.*;
import java.util.*;

public class Main {

    public static int city;
    public static List<List<int[]>> graph;
    public static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        dist = new int[city+1];
        for(int i=0; i<=city; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }
        for(int i=0; i<bus; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new int[]{v2, cost});
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start, end);
    }

    public static void dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{start, 0});
        while(!pq.isEmpty()) {
            int v = pq.peek()[0];
            int cost = pq.peek()[1];
            pq.poll();

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
        System.out.println(dist[end]);
    }
}
