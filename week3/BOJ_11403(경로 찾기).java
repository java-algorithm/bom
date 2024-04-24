import java.io.*;
import java.util.*;

public class Main {

    public static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int edge = Integer.parseInt(st.nextToken());
                if(edge == 1) {
                    list.get(i).add(j);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            int[] visited = new int[N];
            dfs(i, visited);
            for(int j=0; j<N; j++) {
                sb.append(visited[j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void dfs(int n, int[] visited) {
        List<Integer> edge = list.get(n);
        for(int i=0; i<edge.size(); i++) {
            if(visited[edge.get(i)] != 1) {
                visited[edge.get(i)] = 1;
                dfs(edge.get(i), visited);
            }
        }
    }
}
