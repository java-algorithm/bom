import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int round = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<enemy.length; i++) {
            round = i+1;
            pq.offer(enemy[i]);
            if(k-- > 0) {
                continue;
            }
            int knight = pq.poll();
            if(n - knight >= 0) {
                n -= knight;
            }else {
                round--;
                break;
            }
        }
        return round;
    }
}