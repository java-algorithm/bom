import java.util.*;

class Solution {
    private int[][] visited;
    private int oilNum;
    private Map<Integer, Integer> oilMap;
    private int[][] land;

    public int solution(int[][] _land) {
        int answer = 0;
        land = _land;
        visited = new int[land.length][land[0].length];
        oilNum = 1;
        oilMap = new HashMap<>();
        for(int i=0; i<land.length; i++) {
            for(int j=0; j<land[0].length; j++) {
                if(land[i][j] == 1 && visited[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }
        for(int i=0; i<land[0].length; i++) {
            boolean[] check = new boolean[oilNum];
            int count = 0;
            for(int j=0; j<land.length; j++) {
                int num = visited[j][i];
                if(num > 0 && !check[num]) {
                    check[num] = true;
                    count += oilMap.get(num);
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    public void bfs(int startH, int startW) {
        int[] dh = {0, 1, 0, -1};
        int[] dw = {-1, 0, 1, 0};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startH, startW});
        visited[startH][startW] = oilNum;
        int count = 1;
        while(!q.isEmpty()) {
            int h = q.peek()[0];
            int w = q.peek()[1];
            q.poll();
            for(int i=0; i<4; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >= 0 && nextH < land.length && nextW >= 0 && nextW < land[0].length) {
                    if(land[nextH][nextW] == 1 && visited[nextH][nextW] == 0) {
                        visited[nextH][nextW] = oilNum;
                        q.offer(new int[]{nextH, nextW});
                        count++;
                    }
                }
            }
        }
        oilMap.put(oilNum, count);
        oilNum++;
    }
}
