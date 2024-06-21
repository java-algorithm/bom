class Solution {
    private int count;
    private int targetSum;
    private long[] sum;

    public int pathSum(TreeNode root, int _targetSum) {
        targetSum = _targetSum;
        sum = new long[1001];
        dfs(root, 1);
        return count;
    }

    public void dfs(TreeNode node, int depth) {
        if(node == null) {
            return;
        }

        sum[depth] = sum[depth-1] + node.val;
        for(int i=depth-1; i>=0; i--) {
            if(sum[depth] - sum[i] == targetSum) {
                count++;
            }
        }

        dfs(node.left, depth+1);
        dfs(node.right, depth+1);
    }
}
