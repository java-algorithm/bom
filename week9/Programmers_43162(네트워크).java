class Solution {

    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int count = 0;
        visited = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                count++;
                dfs(computers, i);
            }
        }
        return count;
    }

    public void dfs(int[][] computers, int v) {
        int len = computers.length;
        for(int i=0; i<len; i++) {
            if(!visited[i] && computers[v][i] == 1) {
                visited[i] = true;
                dfs(computers, i);
            }
        }
    }
}
