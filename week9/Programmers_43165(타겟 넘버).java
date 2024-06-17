class Solution {

    private int count = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return count;
    }

    public void dfs(int[] numbers, int target, int index, int n) {
        if(index == numbers.length) {
            if(n == target) {
                count++;
            }
            return;
        }

        dfs(numbers, target, index+1, n + numbers[index]);
        dfs(numbers, target, index+1, n - numbers[index]);
    }
}
