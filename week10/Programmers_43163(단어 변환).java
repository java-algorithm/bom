class Solution {

    private String[] words;
    private boolean[] visited;
    private String target;
    private int answer;

    public int solution(String begin, String _target, String[] _words) {
        words = _words;
        target = _target;
        visited = new boolean[words.length];
        answer = Integer.MAX_VALUE;
        dfs(begin, 0, 0);
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }

    public void dfs(String now, int step, int count) {
        if(now.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }
        if(step == words.length) {
            return;
        }

        for(int i=0; i<words.length; i++) {
            if(!visited[i] && check(now, words[i])) {
                visited[i] = true;
                dfs(words[i], step+1, count+1);
                visited[i] = false;
            }
        }
    }

    public boolean check(String s1, String s2) {
        int count = 0;
        int len = s1.length();
        for(int i=0; i<len; i++) {
            count += (s1.charAt(i) == s2.charAt(i)) ? 1 : 0;
        }
        return (count == len-1);
    }
}
