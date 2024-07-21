import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] str = new String[n];
            for(int i=0; i<n; i++) {
                str[i] = br.readLine();
            }
            Arrays.sort(str);
            sb.append(check(str) ? "YES" : "NO").append('\n');
        }
        System.out.print(sb);
    }

    public static boolean check(String[] str) {
        for(int i=1; i<str.length; i++) {
            if(str[i].startsWith(str[i-1])) {
                return false;
            }
        }
        return true;
    }
}