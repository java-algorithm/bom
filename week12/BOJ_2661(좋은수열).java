import java.io.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs("1");
    }

    public static void dfs(String strNum) {
        if(strNum.length() == N) {
            System.out.println(strNum);
            System.exit(0);
            return;
        }

        for(int j=1; j<=3; j++) {
            String str = strNum + j;
            if(check(str)) {
                dfs(str);
            }
        }
    }

    public static boolean check(String strNum) {
        int len = strNum.length();
        for(int i=1; i<=len/2; i++) {
            String str1 = strNum.substring(len-i, len);
            String str2 = strNum.substring(len-i*2, len-i);
            if(str1.equals(str2)) {
                return false;
            }
        }
        return true;
    }
}
