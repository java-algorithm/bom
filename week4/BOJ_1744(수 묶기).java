import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> positiveNum = new ArrayList<>();
        List<Integer> negativeNum = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 0) {
                positiveNum.add(num);
            }else {
                negativeNum.add(num);
            }
        }
        Collections.sort(positiveNum);
        Collections.sort(negativeNum, Collections.reverseOrder());
        int answer = getMaxBindSum(positiveNum) + getMaxBindSum(negativeNum);
        System.out.println(answer);
    }

    public static int getMaxBindSum(List<Integer> list) {
        int max = 0;
        for (int i = list.size()-1; i >= 0; ) {
            if (i == 0) {
                max += list.get(i);
                break;
            }
            int multiply = list.get(i) * list.get(i-1);
            int plus = list.get(i) + list.get(i-1);
            if (multiply < list.get(i)) {
                max += list.get(i--);
            } else if (multiply < plus) {
                max += plus;
                i -= 2;
            } else {
                max += multiply;
                i -= 2;
            }
        }
        return max;
    }
}