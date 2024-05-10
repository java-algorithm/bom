import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] lectures = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
        }
        int left = lectures[0];
        int right = sum;
        int answer = sum;
        while (left <= right) {
            int mid = (left + right) / 2;
            int time = 0;
            int count = 0;
            int maxTime = left;
            for (int i = 0; i < N; i++) {
                if (time + lectures[i] > mid) {
                    maxTime = Math.max(maxTime, time);
                    time = lectures[i];
                    count++;
                } else {
                    time += lectures[i];
                }
            }
            if (time > 0) {
                count++;
                maxTime = Math.max(maxTime, time);
            }
            if (count <= M) {
                answer = Math.min(answer, maxTime);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
