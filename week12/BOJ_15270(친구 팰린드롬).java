import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static boolean[][] friend;
    private static int[][] relation;
    private static boolean[] visited;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friend = new boolean[N+1][N+1];
        relation = new int[M][2];
        visited = new boolean[N+1];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            friend[u][v] = true;
            friend[v][u] = true;
            relation[i][0] = u;
            relation[i][1] = v;
        }
        dfs(0, 0);
        System.out.println((answer == N) ? answer : answer + 1);
    }

    public static void dfs(int start, int count) {
        answer = Math.max(answer, count);

        for(int i=start; i<M; i++) {
            int friend1 = relation[i][0];
            int friend2 = relation[i][1];
            if(!visited[friend1] && !visited[friend2]) {
                visited[friend1] = true;
                visited[friend2] = true;
                dfs(i, count+2);
                visited[friend1] = false;
                visited[friend2] = false;
            }
        }
    }
}
