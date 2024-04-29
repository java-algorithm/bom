import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[10002];
        int[] sortedArr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            count[arr[i]]++;
        }
        for(int i=1; i<=10000; i++) {
            count[i] += count[i-1];
        }
        for(int i=0; i<N; i++) {
            int n = arr[i];
            count[n]--;
            sortedArr[count[n]] = n;
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            sb.append(sortedArr[i]).append('\n');
        }
        System.out.print(sb);
    }
}