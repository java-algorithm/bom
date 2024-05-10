import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Long X = Long.parseLong(st.nextToken());
        Long Y = Long.parseLong(st.nextToken());
        int Z = (int) ((Y * 100) / X);
        if (Z >= 99) {
            System.out.println("-1");
            return;
        }
        int left = 1;
        int right = MAX;
        int answer = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (((Y + mid) * 100 / (X + mid)) > Z) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
