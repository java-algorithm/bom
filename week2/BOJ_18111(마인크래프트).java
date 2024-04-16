import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }
        int height = 0;
        for(int i=0; i<=max; i++) {
            int stackBlock = 0;
            int removeBlock = 0;
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(arr[j][k] < i) {
                        stackBlock += i - arr[j][k];
                    }else {
                        removeBlock += arr[j][k] - i;
                    }
                }
            }
            if(stackBlock > removeBlock + B) {
                continue;
            }
            int time = stackBlock + 2*removeBlock;
            if(min >= time) {
                if(min == time) {
                    height = Math.max(height, i);
                }else {
                    height = i;
                }
                min = time;
            }
        }
        System.out.println(min + " " + height);
    }
}