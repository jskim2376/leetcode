// solution1
// class Solution {
//     TreeNode p;
//     TreeNode q;
//     TreeNode lowestCommonAncestorNode;

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         this.p = p;
//         this.q = q;
//         dfs(root);

//         return lowestCommonAncestorNode;
//     }

//     TreeNode dfs(TreeNode node) {
//         if (node == null)
//             return null;

//         if(node == p || node == q)
//             return node;

//         TreeNode left = dfs(node.left);
//         TreeNode right = dfs(node.right);
//         System.out.printf("val: %d left: %d right: %d", node.val, left != null ? left.val : 0,
//                 right != null ? right.val : 0);

//         if (node == p || node == q) {
//             if (left != null || right != null) {
//                 lowestCommonAncestorNode = node;
//                 return null;
//             }
//             return node;

//         } else {
//             if (left != null && right != null) {
//                 lowestCommonAncestorNode = node;
//             }
//             else if(left != null){
//                 return left;
//             }
//             else if(right != null){
//                 return right;
//             }
//             return null;
//         }
//     }
// }

//solution 2
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 직접 dfs 함수 내에서 최소 공통 조상을 찾아 반환
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q) {
        // 기저 사례: 노드가 null이면 탐색 종료
        if (node == null || node == p || node == q)
            return node;

        // 왼쪽과 오른쪽 자식 노드 탐색
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);

        // 만약 왼쪽과 오른쪽 자식 노드 탐색에서 둘 다 null이 아닌 노드가 반환되었다면, 현재 노드가 LCA임
        if (left != null && right != null)
            return node;

        // 왼쪽이나 오른쪽 자식 노드 중 하나만 null이 아닌 경우, null이 아닌 자식 노드 반환
        return left != null ? left : right;
    }
}
