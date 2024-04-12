import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] cards = new long[n];
        for(int i=0; i<n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        for(int i=0; i<m; i++) {
            mergeCard(cards);
        }
        long sum = 0;
        for(long num : cards) {
            sum += num;
        }
        System.out.println(sum);
    }

    public static void mergeCard(long[] cards) {
        long num = cards[0] + cards[1];
        cards[0] = cards[1] = num;
        if(cards.length >= 3 && num > cards[2]) {
            Arrays.sort(cards);
        }
    }
}
