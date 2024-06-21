import java.util.*;

class Solution {

    private List<int[]> arr;

    public int[][] solution(int n) {
        arr = new ArrayList<>();
        hanoi(1, 2, 3, n);
        int[][] answer = arr.stream().toArray(int[][]::new);
        return answer;
    }

    public void hanoi(int from, int mid, int to, int n) {
        if(n == 0) {
            return;
        }

        hanoi(from, to, mid, n-1);
        arr.add(new int[]{from, to});
        hanoi(mid, from, to, n-1);
    }
}
