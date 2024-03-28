class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // 결과를 저장할 리스트
        if (root == null) // 루트가 null이면 빈 리스트 반환
            return result;

        // Queue를 사용하여 트리의 레벨별로 노드를 순회
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 루트 노드부터 시작

        while (!queue.isEmpty()) { // 큐가 비어있지 않는 동안 반복
            int size = queue.size(); // 현재 레벨의 노드 수
            for (int i = 0; i < size; i++) { // 현재 레벨의 모든 노드를 순회
                var node = queue.poll(); // 큐에서 노드를 하나 꺼냄

                // 현재 레벨의 마지막 노드일 때, 결과 리스트에 값 추가
                if (i == size - 1)
                    result.add(node.val);

                // 왼쪽 자식이 있는 경우, 큐에 추가
                if (node.left != null)
                    queue.offer(node.left);
                // 오른쪽 자식이 있는 경우, 큐에 추가
                if (node.right != null)
                    queue.offer(node.right);
            }
            // 다음 레벨로 이동
            level++;
        }
        return result; // 결과 리스트 반환
    }
}
