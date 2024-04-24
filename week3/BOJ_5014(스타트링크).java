import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int topFloor = Integer.parseInt(st.nextToken());
        int currentFloor = Integer.parseInt(st.nextToken());
        int targetFloor = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        int[] visited = new int[topFloor+1];
        Queue<Integer> q = new LinkedList<>();
        q.offer(currentFloor);
        visited[currentFloor] = 1;
        while(!q.isEmpty()) {
            int f = q.poll();
            if(f == targetFloor) {
                System.out.println(visited[targetFloor]-1);
                return;
            }
            if(f+up <= topFloor && visited[f+up] == 0) {
                visited[f+up] = visited[f]+1;
                q.offer(f+up);
            }

            if(f-down >= 1 && visited[f-down] == 0) {
                visited[f-down] = visited[f]+1;
                q.offer(f-down);
            }
        }
        System.out.println("use the stairs");
    }
}
