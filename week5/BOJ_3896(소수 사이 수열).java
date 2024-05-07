import java.io.*;
import java.util.*;

public class Main {

    public static final int MAX = 1299710;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> primeNumber = getPrimeNumber();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 1) {
                System.out.println('0');
                continue;
            }
            binarySearch(primeNumber, num);
        }
    }

    public static void binarySearch(List<Integer> primeNumber, int num) {
        int left = 0;
        int right = primeNumber.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int primeNum = primeNumber.get(mid);
            if (num <= primeNum) {
                right = mid - 1;
                if (num == primeNum) {
                    System.out.println('0');
                    return;
                }
            } else {
                left = mid + 1;
            }
        }
        int answer = primeNumber.get(left) - primeNumber.get(left - 1);
        System.out.println(answer);
    }

    public static List<Integer> getPrimeNumber() {
        boolean[] check = new boolean[MAX];
        List<Integer> primeNumber = new ArrayList<>();
        for (int i = 2; i < MAX; i++) {
            if (check[i]) {
                continue;
            }
            primeNumber.add(i);
            for (int j = i; j < MAX; j += i) {
                if (!check[j]) {
                    check[j] = true;
                }
            }
        }
        return primeNumber;
    }
}
