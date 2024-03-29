class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        var current = root;
        while (true) {
            if (current.val == val) {
                return current;
            } else if (current.val > val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

}