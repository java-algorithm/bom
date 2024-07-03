import java.util.*;

class Solution {
    private boolean[] visited;
    private int[] weak;
    private int[] dist;
    private int answer;

    public int solution(int n, int[] _weak, int[] _dist) {
        weak = _weak;
        dist = _dist;
        answer = Integer.MAX_VALUE;
        visited = new boolean[n];
        int len = weak.length;
        for(int i=0; i<len; i++) {
            int[] weakArr = new int[len];
            for(int j=0; j<len; j++) {
                int index = (j+i)%len;
                if((j+i)/len >= 1) {
                    weakArr[j] = weak[index] + n;
                }else {
                    weakArr[j] = weak[index];
                }
            }

            for(int j=1; j<=dist.length; j++) {
                dfs(weakArr, new int[j], 0);
            }
        }
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    public void dfs(int[] weakArr, int[] arr, int index) {
        if(index == arr.length) {
            check(weakArr, arr);
            return;
        }

        for(int i=0; i<dist.length; i++) {
            if(!visited[i]) {
                arr[index] = dist[i];
                visited[i] = true;
                dfs(weakArr, arr, index+1);
                visited[i] = false;
            }
        }
    }

    public void check(int[] weakArr, int[] arr) {
        int weakIndex = 0;
        int arrIndex = 0;
        while(weakIndex < weakArr.length && arrIndex < arr.length) {
            int start = weakArr[weakIndex];
            int end = start + arr[arrIndex];
            while(weakArr[weakIndex] <= end) {
                weakIndex++;
                if(weakIndex == weakArr.length) {
                    break;
                }
            }
            arrIndex++;
        }
        if(weakIndex == weakArr.length) {
            answer = Math.min(answer, arr.length);
        }
    }
}
