import javax.swing.tree.TreeNode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    TreeNode p;
    TreeNode q;
    TreeNode lowestCommonAncestorNode;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);

        return lowestCommonAncestorNode;
    }

    TreeNode dfs(TreeNode node) {
        if (node == null)
            return null;

        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        System.out.printf("val: %d left: %d right: %d", node.val, left != null ? left.val : 0,
                right != null ? right.val : 0);

        if (node == p || node == q) {
            if (left != null || right != null) {
                lowestCommonAncestorNode = node;
                return null;
            }
            return node;

        } else {
            if (left != null && right != null) {
                lowestCommonAncestorNode = node;
            } else if (left != null) {
                return left;
            } else if (right != null) {
                return right;
            }
            return null;
        }
    }
}