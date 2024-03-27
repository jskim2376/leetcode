// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;

//     TreeNode() {
//     }

//     TreeNode(int val) {
//         this.val = val;
//     }

//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    int longestZigZagLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, null, -1);
        return longestZigZagLength;
    }

    enum Direction {
        LEFT,
        RIGHT
    }

    void dfs(TreeNode node, Direction direction, int currentLength) {
        if (node == null) {
            longestZigZagLength = Math.max(longestZigZagLength, currentLength);
            return;
        }

        System.out.println(direction + " currentLength: " + currentLength);
        if (direction == Direction.LEFT) {
            dfs(node.right, Direction.RIGHT, currentLength + 1);
            dfs(node.left, Direction.LEFT, 0);
        } else if (direction == Direction.RIGHT) {
            dfs(node.left, Direction.LEFT, currentLength + 1);
            dfs(node.right, Direction.RIGHT, 0);
        } else {
            dfs(node.left, Direction.LEFT, currentLength + 1);
            dfs(node.right, Direction.RIGHT, currentLength + 1);
        }
    }
}