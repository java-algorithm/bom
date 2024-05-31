import java.io.*;
import java.util.*;

public class Main {

    public static int city;
    public static List<List<int[]>> graph;
    public static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        city = Integer.parseInt(st.nextToken());
        int bus = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        dist = new long[city+1];
        for(int i=0; i<=city; i++) {
            graph.add(new ArrayList<>());
            dist[i] = Long.MAX_VALUE;
        }
        for(int i=0; i<bus; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new int[]{v2, cost});
        }
        bellmanFord(1);
    }

    public static void bellmanFord(int start) {
        dist[start] = 0;
        for(int i=1; i<=city; i++) {
            for(int j=1; j<=city; j++) {
                List<int[]> list = graph.get(j);
                for(int k=0; k<list.size(); k++) {
                    int nextV = list.get(k)[0];
                    int nextCost = list.get(k)[1];
                    if(dist[j] != Long.MAX_VALUE && dist[nextV] > dist[j] + nextCost) {
                        dist[nextV] = dist[j] + nextCost;

                        // city(정점 개수)번째 반복에 갱신되는 값이 있으면 음수 사이클 존재
                        if(i == city) {
                            System.out.println("-1");
                            return;
                        }
                    }
                }
            }
        }
        for(int i=2; i<=city; i++) {
            System.out.println((dist[i] == Long.MAX_VALUE) ? "-1" : dist[i]);
        }
    }
}
