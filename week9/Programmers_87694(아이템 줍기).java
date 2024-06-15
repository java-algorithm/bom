import java.util.*;

class Solution {

    private int[][] board;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int len = rectangle.length;
        board = new int[101][101];

        // 좌표를 두 배로 확대해서 도형의 테두리 공간을 만든다
        for(int i=0; i<len; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            // 좌표*2 도형 내부를 1로 채우기
            for(int j=y1; j<=y2; j++) {
                for(int k=x1; k<=x2; k++) {
                    board[j][k] = 1;
                }
            }
        }

        for(int i=0; i<len; i++) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            // 도형의 테두리만 남기고 나머지를 0으로 채우기
            for(int j=y1+1; j<=y2-1; j++) {
                for(int k=x1+1; k<=x2-1; k++) {
                    board[j][k] = 0;
                }
            }
        }
        int result = bfs(rectangle, characterX*2, characterY*2, itemX*2, itemY*2);
        return result/2;
    }

    public int bfs(int[][] rectangle, int characterW, int characterH, int itemW, int itemH) {
        int[] dh = {0, 1, 0, -1};
        int[] dw = {-1, 0, 1, 0};
        int[][] visited = new int[101][101];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{characterH, characterW});
        while(!q.isEmpty()) {
            int h = q.peek()[0];
            int w = q.peek()[1];
            q.poll();

            if(h == itemH && w == itemW) {
                return visited[h][w];
            }

            for(int i=0; i<4; i++) {
                int nextH = h + dh[i];
                int nextW = w + dw[i];
                if(nextH >= 0 && nextH <= 100 && nextW >= 0 && nextW <= 100) {
                    if(visited[nextH][nextW] == 0 && board[nextH][nextW] == 1) {
                        visited[nextH][nextW] = visited[h][w]+1;
                        q.offer(new int[]{nextH, nextW});
                    }
                }
            }
        }
        return 0;
    }
}
