import java.io.*;
import java.util.*;

public class Main {

    public static List<List<Integer>> graph;
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new int[N+1];
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        dfs(1);

        StringBuffer sb = new StringBuffer();
        for(int i=2; i<=N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int n) {
        List<Integer> list = graph.get(n);
        for(int i=0; i<list.size(); i++) {
            int v = list.get(i);
            if(visited[v] == 0) {
                visited[v] = n;
                dfs(v);
            }
        }
    }
}