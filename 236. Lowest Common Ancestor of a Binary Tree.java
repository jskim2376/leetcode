// solution1
// class Solution {
//     // 세 개의 전역 변수 선언: 두 타겟 노드 p, q와 최소 공통 조상 노드
//     TreeNode p;
//     TreeNode q;
//     TreeNode lowestCommonAncestorNode;

//     // 주어진 루트 노드와 두 타겟 노드를 사용하여 최소 공통 조상을 찾는 메서드
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         this.p = p;
//         this.q = q;
//         dfs(root); // 깊이 우선 탐색을 시작하여 최소 공통 조상을 찾음

//         return lowestCommonAncestorNode; // 찾은 최소 공통 조상 노드 반환
//     }

//     // 깊이 우선 탐색(DFS)을 수행하는 메서드
//     TreeNode dfs(TreeNode node) {
//         if (node == null) // 탐색 중인 노드가 null이면 탐색 종료
//             return null;

//         TreeNode left = dfs(node.left); // 왼쪽 자식 노드로의 DFS 수행
//         TreeNode right = dfs(node.right); // 오른쪽 자식 노드로의 DFS 수행
//         // 주석 제거: 현재 노드와 자식 노드들의 값을 출력하는 불필요한 출력문

//         if (node == p || node == q) { // 현재 노드가 p 또는 q와 일치하면
//             if (left != null || right != null) {
//                 lowestCommonAncestorNode = node; // 만약 왼쪽 또는 오른쪽 자식이 이미 찾은 경우, 현재 노드가 LCA임
//                 return null;
//             }
//             return node; // p 또는 q를 찾았으나, 다른 하나는 아직 찾지 못한 경우 현재 노드 반환

//         } else { // 현재 노드가 p 또는 q가 아닌 경우
//             if (left != null && right != null) {
//                 lowestCommonAncestorNode = node; // 왼쪽과 오른쪽 모두에서 타겟 노드를 찾았다면, 현재 노드가 LCA임
//             } else if (left != null) {
//                 return left; // 왼쪽 자식에서만 타겟 노드를 찾았다면, 왼쪽 자식 반환
//             } else if (right != null) {
//                 return right; // 오른쪽 자식에서만 타겟 노드를 찾았다면, 오른쪽 자식 반환
//             }
//             return null; // 타겟 노드를 찾지 못했다면 null 반환
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
        if (node == null)
            return null;

        // 현재 노드가 p 또는 q와 일치할 경우, 추가 탐색을 중지하고 현재 노드를 반환합니다.
        // 만약 현재 노드가 p 또는 q 중 하나를 자식으로 가지고 있으면, 현재 노드는 최소 공통 조상이 됩니다.
        // 최소 공통 조상이 현재 노드보다 상위에 있으면, 다음 탐색 단계에서 해당 조상 노드가 찾아져 반환됩니다.
        if (node == p || node == q)
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
