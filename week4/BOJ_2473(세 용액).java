import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        long minAbs = Math.abs(arr[0] + arr[1] + arr[2]);
        long[] answer = new long[]{arr[0], arr[1], arr[2]};
        for (int i = 0; i < N - 2; i++) {
            long[] result = twoPointer(arr, i);
            long resultAbs = Math.abs(result[0] + result[1] + result[2]);
            if (minAbs > resultAbs) {
                minAbs = resultAbs;
                answer = result.clone();
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }

    public static long[] twoPointer(long[] arr, int index) {
        int left = index + 1;
        int right = arr.length - 1;
        int leftIndex = left;
        int rightIndex = right;
        long minAbs = Math.abs(arr[left] + arr[right] + arr[index]);
        while (left < right) {
            long sum = arr[index] + arr[left] + arr[right];
            if (minAbs > Math.abs(sum)) {
                minAbs = Math.abs(sum);
                leftIndex = left;
                rightIndex = right;
            }
            if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }
        return new long[]{arr[index], arr[leftIndex], arr[rightIndex]};
    }
}
