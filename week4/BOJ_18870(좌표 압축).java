import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++) {
            map.put(list.get(i), i);
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }
        System.out.println(sb);
    }
}