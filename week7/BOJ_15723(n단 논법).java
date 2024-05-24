import java.io.*;
import java.util.*;

public class Main {

    public static int n;
    public static boolean[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new boolean[27][27];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';
            graph[a][b] = true;
        }
        int m = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';
            sb.append(bfs(a, b)).append('\n');
        }
        System.out.print(sb);
    }

    public static char bfs(int start, int end) {
        boolean[] visited = new boolean[27];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int v = q.poll();
            if(v == end) {
                return 'T';
            }

            for(int i=0; i<27; i++) {
                if(graph[v][i] && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
        return 'F';
    }
}
