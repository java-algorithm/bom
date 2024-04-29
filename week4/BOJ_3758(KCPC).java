import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int totalTeam = Integer.parseInt(st.nextToken());
            int totalQuiz = Integer.parseInt(st.nextToken());
            int teamId = Integer.parseInt(st.nextToken());
            int logCount = Integer.parseInt(st.nextToken());

            int[][] score = new int[totalTeam+1][totalQuiz+1];
            int[] submission = new int[totalTeam+1];
            int[] lastTime = new int[totalTeam+1];
            Arrays.fill(lastTime, logCount);
            List<Team> teamList = new ArrayList<>();
            for(int j=0; j<logCount; j++) {
                st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                int q = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                score[t][q] = Math.max(score[t][q], s);
                submission[t]++;
                lastTime[t] = j;
            }
            for(int j=1; j<=totalTeam; j++) {
                int totalScore = 0;
                for(int k=1; k<=totalQuiz; k++) {
                    totalScore += score[j][k];
                }
                teamList.add(new Team(j, totalScore, submission[j], lastTime[j]));
            }
            Collections.sort(teamList);

            for(int j=0; j<totalTeam; j++) {
                if(teamId == teamList.get(j).teamId) {
                    sb.append(j+1).append('\n');
                    break;
                }
            }
        }
        System.out.print(sb);
    }

    public static class Team implements Comparable<Team>{
        int teamId;
        int score;
        int submissionCount;
        int lastTime;

        public Team(int teamId, int score, int count, int time) {
            this.teamId = teamId;
            this.score = score;
            this.submissionCount = count;
            this.lastTime = time;
        }

        @Override
        public int compareTo(Team t) {
            if(this.score == t.score) {
                if(t.submissionCount == this.submissionCount) {
                    return Integer.compare(this.lastTime, t.lastTime);
                }
                return Integer.compare(this.submissionCount, t.submissionCount);
            }
            return Integer.compare(t.score, this.score);
        }
    }
}
