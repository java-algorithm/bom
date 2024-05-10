import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> S = new ArrayList<>();
        for(int i=0; i<N; i++) {
            S.add(br.readLine());
        }
        Collections.sort(S);
        List<String> strList = new ArrayList<>();
        for(int i=0; i<M; i++) {
            strList.add(br.readLine());
        }
        int count = 0;
        for(int i=0; i<M; i++) {
            int left = 0;
            int right = N-1;
            while(left <= right) {
                int mid = (left + right)/2;
                int compare = S.get(mid).compareTo(strList.get(i));
                if(compare >= 0) {
                    if(S.get(mid).startsWith(strList.get(i))) {
                        count++;
                        break;
                    }
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
        }
        System.out.println(count);
    }
}
