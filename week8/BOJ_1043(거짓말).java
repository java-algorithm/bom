import java.io.*;
import java.util.*;

public class Main {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }
        st = new StringTokenizer(br.readLine());
        int truthNum = Integer.parseInt(st.nextToken());
        boolean[] truth = new boolean[N+1];
        for(int i=0; i<truthNum; i++) {
            int truthIndex = Integer.parseInt(st.nextToken());
            truth[truthIndex] = true;
        }
        List<List<Integer>> attendee = new ArrayList<>();
        for(int i=0; i<=M; i++) {
            attendee.add(new ArrayList<>());
        }
        for(int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j=1; j<=num; j++) {
                int attendeeIndex = Integer.parseInt(st.nextToken());
                attendee.get(i).add(attendeeIndex);
                union(attendee.get(i).get(0), attendeeIndex);
            }
        }
        // 진실을 아는 사람의 parent 도 진실을 알도록 업데이트
        for(int i=1; i<=N; i++) {
            if(truth[i]) {
                truth[find(i)] = true;
            }
        }

        int answer = M;
        for(int i=1; i<=M; i++) {
            // 파티 참석자의 부모 노드가 진실을 아는 사람이면 거짓말 할 수 없음
            for(int j=0; j<attendee.get(i).size(); j++) {
                int attendeeParent = find(attendee.get(i).get(j));
                if(truth[attendeeParent]) {
                    answer--;
                    break;
                }
            }
        }
        System.out.println(answer);
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
