public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // 삭제할 노드 찾음
        else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // 두 개의 자식을 가진 경우
            TreeNode minNode = root.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }

            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }
}