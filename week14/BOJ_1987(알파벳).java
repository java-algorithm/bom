import java.io.*;
import java.util.*;

public class Main {

    private static int R, C;
    private static char[][] board;
    private static boolean[][] visited;
    private static boolean[] check;
    private static int[] dh = {-1, 0, 1, 0};
    private static int[] dw = {0, 1, 0, -1};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[R][C];
        check = new boolean[30];
        for(int i=0; i<R; i++) {
            String input = br.readLine();
            for(int j=0; j<C; j++) {
                board[i][j] = input.charAt(j);
            }
        }
        visited[0][0] = true;
        check[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);
        System.out.println(answer);
    }

    public static void dfs(int h, int w, int depth) {
        if(depth > R*C) {
            return;
        }
        answer = Math.max(answer, depth);

        for(int i=0; i<4; i++) {
            int nextH = h + dh[i];
            int nextW = w + dw[i];
            if(nextH >= 0 && nextH < R && nextW >=0 && nextW < C) {
                int index = board[nextH][nextW] - 'A';
                if(!visited[nextH][nextW] & !check[index]) {
                    check[index] = true;
                    dfs(nextH, nextW, depth+1);
                    check[index] = false;
                }
            }
        }
    }
}