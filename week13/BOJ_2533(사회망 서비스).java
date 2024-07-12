import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] visited;
    private static int N;
    private static int[][] d;
    private static List<List<Integer>> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        d = new int[N+1][2];
        tree = new ArrayList<>();
        visited = new boolean[N+1];
        for(int i=0; i<=N; i++) {
            tree.add(new ArrayList<>());
            d[i][1] = 1;
        }
        for(int i=0; i<N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            tree.get(v1).add(v2);
            tree.get(v2).add(v1);
        }
        // d[i][0] : i 노드가 얼리어답터가 아닌 경우의 최소 얼리어답터 수
        // d[i][1] : i 노드가 얼리어답터인 경우의 최소 얼리어답터 수
        visited[1] = true;
        dfs(1);
        System.out.println(Math.min(d[1][0], d[1][1]));
    }

    public static void dfs(int n) {
        List<Integer> child = tree.get(n);
        for(int i=0; i<child.size(); i++) {
            int next = child.get(i);
            if(!visited[next]) {
                visited[next] = true;
                dfs(next);
                d[n][0] += d[next][1];
                d[n][1] += Math.min(d[next][0], d[next][1]);
            }
        }
    }
}
