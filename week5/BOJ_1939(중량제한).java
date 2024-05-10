import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph.get(A).add(new int[]{B, C});
            graph.get(B).add(new int[]{A, C});
            max = Math.max(max, C);
            min = Math.min(min, C);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int left = min;
        int right = max;
        int answer = left;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (!checkPathWeight(start, end, mid)) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean checkPathWeight(int start, int end, int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int v = q.poll();
            if (v == end) {
                return true;
            }
            List<int[]> list = graph.get(v);
            for (int i = 0; i < list.size(); i++) {
                int[] edge = list.get(i);
                int vertex = edge[0];
                if (edge[1] > 0 && edge[1] >= weight && !visited[vertex]) {
                    visited[vertex] = true;
                    q.offer(vertex);
                }
            }
        }
        return false;
    }
}
