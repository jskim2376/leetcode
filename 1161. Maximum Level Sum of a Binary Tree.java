class Solution {
    public int maxLevelSum(TreeNode root) {
        List<Integer> levelSum = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            levelSum.add(sum);
        }

        // 최대값과 인덱스 초기화
        int maxVal = Integer.MIN_VALUE;
        int maxIndex = -1;
        // 리스트 순회하며 최대값과 그 인덱스 찾기
        for (int i = 0; i < levelSum.size(); i++) {
            if (levelSum.get(i) > maxVal) {
                maxVal = levelSum.get(i);
                maxIndex = i;
            }
        }

        return maxIndex + 1;
    }
}