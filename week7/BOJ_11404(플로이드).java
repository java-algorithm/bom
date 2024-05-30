import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX = 10_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(i == j) {
                    graph[i][j] = 0;
                }else {
                    graph[i][j] = MAX;
                }
            }
        }
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sb.append((graph[i][j] == MAX) ? 0 : graph[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
