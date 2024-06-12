import java.io.*;
import java.util.*;

public class Main {

    public static Map<String, Integer> manitoIndex;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                System.out.print(sb);
                return;
            }
            manitoIndex = new HashMap<>();
            parent = new int[N+1];
            for(int i=1; i<=N; i++) {
                parent[i] = i;
            }
            int num = 0;
            Set<Integer> set = new HashSet<>();
            for(int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String manito1 = st.nextToken();
                String manito2 = st.nextToken();
                if(!manitoIndex.containsKey(manito1)) {
                    manitoIndex.put(manito1, num++);
                }
                if(!manitoIndex.containsKey(manito2)) {
                    manitoIndex.put(manito2, num++);
                }
                int x = find(parent[manitoIndex.get(manito1)]);
                int y = find(parent[manitoIndex.get(manito2)]);
                union(x, y);
            }
            for(int i=1; i<=N; i++) {
                if(i != parent[i]) {
                    set.add(parent[i]);
                }
            }
            sb.append(t++).append(' ').append(set.size()).append('\n');
        }
    }

    public static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y) {
            return;
        }
        parent[y] = x;
    }
}
