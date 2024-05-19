import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] volume = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volume[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] d = new boolean[N + 1][M + 1];
        d[0][S] = true;
        for (int i = 1; i <= N; i++) {
            for (int vol = 0; vol <= M; vol++) {
                // 이전에 곡에서 연주 가능한 볼륨일 경우
                if (d[i - 1][vol]) {
                    if (vol + volume[i] <= M) {
                        d[i][vol + volume[i]] = true;
                    }
                    if (vol - volume[i] >= 0) {
                        d[i][vol - volume[i]] = true;
                    }
                }
            }
        }
        int answer = -1;
        for (int i = M; i >= 0; i--) {
            if (d[N][i]) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
