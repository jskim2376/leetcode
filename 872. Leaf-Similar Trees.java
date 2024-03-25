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
            // Integer를 == 비교하면 -128 ~ 127 까지의 값만 비교가능
            if (!root1Leaf.pop().equals(root2Leaf.pop())) {
                return false;
            }
        }

        return true;
    }

    public void getLeafNode(TreeNode node, Stack<Integer> stack) {
        // 마지막 노드 일경우 push
        if (node.left == null && node.right == null) {
            stack.push(node.val);
        }
        if (node.left != null)
            getLeafNode(node.left, stack);
        if (node.right != null)
            getLeafNode(node.right, stack);
    }
}