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
    // 가장 긴 지그재그 경로의 길이 저장
    int longestZigZagLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root.left, Direction.LEFT, 0);
        dfs(root.right, Direction.RIGHT, 0);
        return longestZigZagLength; // 최장 경로 길이 반환
    }

    enum Direction { // 탐색 방향
        LEFT, RIGHT
    }

    void dfs(TreeNode node, Direction direction, int currentLength) {
        if (node == null) {
            longestZigZagLength = Math.max(longestZigZagLength, currentLength); // 최대 길이 업데이트
            return;
        }
        // 왼쪽 또는 오른쪽으로 이동 시 방향 변경 및 경로 길이 계산
        if (direction == Direction.LEFT) {
            dfs(node.right, Direction.RIGHT, currentLength + 1); // 왼쪽에서 오른쪽으로 이동
            dfs(node.left, Direction.LEFT, 0); // 경로 리셋
        } else {
            dfs(node.left, Direction.LEFT, currentLength + 1); // 오른쪽에서 왼쪽으로 이동
            dfs(node.right, Direction.RIGHT, 0); // 경로 리셋
        }
    }
}
