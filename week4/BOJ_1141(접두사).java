import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] str = new String[N];
        for(int i=0; i<N; i++) {
            str[i] = br.readLine();
        }
        Arrays.sort(str);
        int answer = 1;
        for(int i=0; i<N-1; i++) {
            if(!str[i+1].startsWith(str[i])) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}