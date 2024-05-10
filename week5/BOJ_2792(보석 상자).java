import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] jewel = new int[M];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < M; i++) {
            jewel[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, jewel[i]);
        }
        Arrays.sort(jewel);
        int answer = max;
        int low = 1;
        int high = max;
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int j = 0; j < M; j++) {
                count += jewel[j] / mid;
                if (jewel[j] % mid != 0) {
                    count++;
                }
            }
            if (count > N) {
                low = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                high = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
