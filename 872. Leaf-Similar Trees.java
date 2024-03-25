import java.util.Stack;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Stack<Integer> root1Leaf = new Stack<>();
        getLeafNode(root1, root1Leaf);

        Stack<Integer> root2Leaf = new Stack<>();
        getLeafNode(root2, root2Leaf);

        if (root1Leaf.size() != root2Leaf.size())
            return false;

        while (!root1Leaf.isEmpty()) {
            if (root1Leaf.pop() != root2Leaf.pop()) {
                return false;
            }
        }

        return true;
    }

    public void getLeafNode(TreeNode node, Stack<Integer> stack) {
        if (node.left == null && node.right == null) {
            stack.push(node.val);
        }
        if (node.left != null)
            getLeafNode(node.left, stack);
        if (node.right != null)
            getLeafNode(node.right, stack);
    }
}