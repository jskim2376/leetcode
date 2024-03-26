class Solution {
    int good = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);

        return good;
    }

    void dfs(TreeNode node, int maxValue) {
        if (node == null)
            return;

        if (node.val >= maxValue) {
            maxValue = node.val;
            good++;
        }
        dfs(node.left, maxValue);
        dfs(node.right, maxValue);
    }
}