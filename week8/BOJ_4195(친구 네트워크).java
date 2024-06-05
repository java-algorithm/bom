import java.io.*;
import java.util.*;

public class Main {

    public static Map<String, Integer> friendIndex;
    public static int[] parent;
    public static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int F = Integer.parseInt(br.readLine());
            friendIndex = new HashMap<>();
            count = new int[F*2];
            parent = new int[F*2];
            for(int i=1; i<F*2; i++) {
                parent[i] = i;
            }
            int num = 0;
            for(int i=0; i<F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();
                if(!friendIndex.containsKey(friend1)) {
                    count[num] = 1;
                    friendIndex.put(friend1, num++);
                }
                if(!friendIndex.containsKey(friend2)) {
                    count[num] = 1;
                    friendIndex.put(friend2, num++);
                }
                int x = find(friendIndex.get(friend1));
                int y = find(friendIndex.get(friend2));
                union(x, y);
                sb.append(count[x]).append('\n');
            }
        }
        System.out.print(sb);
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
        count[x] += count[y];
    }
}
