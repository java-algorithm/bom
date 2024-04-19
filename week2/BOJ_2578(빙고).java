import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for(int i=0; i<5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                int num = Integer.parseInt(st.nextToken());
                removeNumber(board, num);
                answer++;
                if(isBingo(board)) {
                    System.out.println(answer);
                    return;
                }
            }
        }
    }

    public static void removeNumber(int[][] board, int num) {
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if(board[i][j] == num) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static boolean isBingo(int[][] board) {
        int bingo = 0;
        // 가로, 세로 카운트
        for(int i=0; i<5; i++) {
            int count1 = 0;
            int count2 = 0;
            for(int j=0; j<5; j++) {
                if(board[i][j] == 0) {
                    count1++;
                }
                if(board[j][i] == 0) {
                    count2++;
                }
            }
            if(count1 == 5) {
                bingo++;
            }
            if(count2 == 5) {
                bingo++;
            }
        }

        // 대각선 카운트
        int count1 = 0;
        int count2 = 0;
        for(int i=0; i<5; i++) {
            if(board[i][i] == 0) {
                count1++;
            }
            if(board[i][4-i] == 0) {
                count2++;
            }
        }
        if(count1 == 5) {
            bingo++;
        }
        if(count2 == 5) {
            bingo++;
        }
        return bingo >= 3;
    }
}