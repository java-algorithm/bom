import java.io.*;
import java.util.*;

public class Main {

    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()) == 1);
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            updateSwitch(arr, student, num);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++) {
            sb.append(arr[i] ? '1' : '0');
            if(i % 20 == 0) {
                sb.append('\n');
            }else {
                sb.append(' ');
            }
        }
        System.out.println(sb);
    }

    public static void updateSwitch(boolean[] arr, int student, int num) {
        if(student == 1) {
            for(int i=1; i<=N; i++) {
                if(i % num == 0) {
                    arr[i] = !arr[i];
                }
            }
        }else {
            for(int i=0; (num-i>=1) && (num+i <= N); i++) {
                if(arr[num-i] == arr[num+i]) {
                    arr[num-i] = arr[num+i] = !arr[num+i];
                }else {
                    return;
                }
            }
        }
    }
}