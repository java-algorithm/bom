class Solution {
    private int answer = 0;
    private int[][] dungeons;
    private boolean[] visited;

    public int solution(int k, int[][] _dungeons) {
        dungeons = _dungeons;
        visited = new boolean[dungeons.length];
        dfs(k, 0);
        return answer;
    }

    public void dfs(int k, int count) {
        answer = Math.max(answer, count);

        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}
