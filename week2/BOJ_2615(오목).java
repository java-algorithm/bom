import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] omok = new int[21][21];
        for(int i=1; i<=19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=19; j++) {
                omok[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1; i<=19; i++) {
            for(int j=1; j<=19; j++) {
                int color = omok[i][j];
                if(color == 0) {
                    continue;
                }
                int count1 = 0;
                int count2 = 0;
                for(int k=0; k<5; k++) {
                    // 세로
                    if(i+k <= 19) {
                        if(omok[i][j] == omok[i+k][j]) {
                            count1++;
                        }
                    }
                    // 가로
                    if(j+k <= 19) {
                        if(omok[i][j] == omok[i][j+k]) {
                            count2++;
                        }
                    }
                }
                if((count1 == 5 && omok[i+5][j] != color && omok[i-1][j] != color)
                        || (count2 == 5 && omok[i][j+5] != color && omok[i][j-1] != color)) {
                    System.out.println(color);
                    System.out.println(i + " " + j);
                    return;
                }

                count1 = 0;
                count2 = 0;
                for(int k=0; k<5; k++) {
                    // 오른쪽 위 대각선
                    if(j-k >= 1 && i+k <= 19) {
                        if(omok[i][j] == omok[i+k][j-k]) {
                            count1++;
                        }
                    }
                    // 오른쪽 아래 대각선
                    if(i+k <= 19 && j+k <= 19) {
                        if(omok[i][j] == omok[i+k][j+k]) {
                            count2++;
                        }
                    }
                }
                if(count1 == 5 && omok[i+5][j-5] != color && omok[i-1][j+1] != color) {
                    System.out.println(color);
                    System.out.println((i+4) + " " + (j-4));
                    return;
                }

                if(count2 == 5 && omok[i+5][j+5] != color && omok[i-1][j-1] != color) {
                    System.out.println(color);
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
        System.out.println("0");
    }
}