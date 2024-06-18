import java.util.*;

class Solution {
    private String[][] tickets;
    private boolean[] visited;
    private List<List<String>> pathList;

    public String[] solution(String[][] _tickets) {
        tickets = _tickets;
        visited = new boolean[tickets.length];
        pathList = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("ICN");
        path = dfs(path, "ICN");
        Collections.sort(pathList, (o1, o2) -> {
            for(int i=0; i<o1.size(); i++) {
                String s1 = o1.get(i);
                String s2 = o2.get(i);
                if(!s1.equals(s2)) {
                    return s1.compareTo(s2);
                }
            }
            return 0;
        });
        String[] answer = pathList.get(0).stream().toArray(String[]::new);
        return answer;
    }

    public List<String> dfs(List<String> path, String now) {
        if(path.size() == tickets.length+1) {
            pathList.add(new ArrayList<String>(path));
            return path;
        }

        for(int i=0; i<tickets.length; i++) {
            String v1 = tickets[i][0];
            String v2 = tickets[i][1];
            if(v1.equals(now) && !visited[i]) {
                path.add(v2);
                visited[i] = true;
                dfs(path, v2);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
        return path;
    }
}
