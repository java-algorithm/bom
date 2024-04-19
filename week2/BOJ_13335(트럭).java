import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // [트럭 무게, 현재 위치]
        List<int[]> truckList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int truck = Integer.parseInt(st.nextToken());
            truckList.add(new int[]{truck, -1*i});
        }

        int time = 0;
        int currentWeight = 0;
        int count = 0;
        int index = 0;
        while(true) {
            // 마지막 트럭이 다리를 건넜다면 종료
            if(truckList.get(n-1)[1] > length) {
                System.out.println(time);
                return;
            }

            for(int i=index; i<n; i++) {
                int w = truckList.get(i)[0];
                int l = truckList.get(i)[1];
                if(l > 0) { // 다리 위에 있는 트럭
                    moveTruck(truckList, i);
                }else if(l == 0) { // 다리 입구에 위치한 트럭
                    // 진입 가능 트럭(무게 중량 초과 x, 다리 길이가 트럭 개수보다 작은 경우)
                    if((currentWeight + w <= maxWeight) && (count < length)) {
                        moveTruck(truckList, i);
                        currentWeight += w;
                        count++;
                    }else {
                        break;
                    }
                }else { // 다리에 진입하지 않은 트럭
                    moveTruck(truckList, i);
                }

                // 다리를 모두 건넌 경우
                if(l >= length) {
                    currentWeight -= w;
                    count--;
                    index++;
                }
            }
            time++;
        }
    }

    public static void moveTruck(List<int[]> truckList, int index) {
        int[] truck = truckList.get(index);
        truck[1]++;
        truckList.set(index, truck);
    }
}