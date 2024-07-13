import java.io.*;
import java.util.*;

public class Main {

    private static List<List<Integer>> tree;
    private static boolean[] visited;
    private static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        visited = new boolean[N+1];
        d = new int[N+1][2];
        for(int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            d[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        visited[1] = true;
        dfs(1);
        System.out.println(Math.max(d[1][0], d[1][1]));
    }

    public static void dfs(int n) {
        List<Integer> child = tree.get(n);
        for(int i=0; i<child.size(); i++) {
            int next = child.get(i);
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
                // d[i][0] = i 노드가 우수 마을이 아닌 경우
                // d[i][1] = i 노드가 우수 마을인 경우
                d[n][0] += Math.max(d[next][0], d[next][1]);
                d[n][1] += d[next][0];
            }
        }
    }
}
