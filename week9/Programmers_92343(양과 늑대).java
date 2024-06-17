class Solution {

    private boolean[] visited;
    private int answer = 0;
    private int[] info;
    private int[][] edges;

    public int solution(int[] _info, int[][] _edges) {
        answer = 0;
        info = _info;
        edges = _edges;
        visited = new boolean[info.length+1];
        visited[0] = true;
        dfs(1, 0);
        return answer;
    }

    public void dfs(int sheep, int wolf) {
        if(wolf < sheep) {
            answer = Math.max(answer, sheep);
        }else {
            return;
        }

        for(int i=0; i<edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            if(visited[parent] && !visited[child]) {
                visited[child] = true;
                if(info[child] == 0) {
                    dfs(sheep+1, wolf);
                }else {
                    dfs(sheep, wolf+1);
                }
                visited[child] = false;
            }
        }
    }
}
