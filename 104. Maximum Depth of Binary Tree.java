class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0; // 빈 노드라면 깊이는 0
        } else {
            // 왼쪽 자식 노드와 오른쪽 자식 노드에 대해 재귀적으로 maxDepth를 호출
            int leftDepth = dfs(root.left);
            int rightDepth = dfs(root.right);
            // 더 큰 깊이에 1을 더해 반환 (현재 노드를 포함하기 위해)
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}