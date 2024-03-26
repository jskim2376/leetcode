// // Solution 1
// class Solution {
//     // 결과를 저장하기 위한 리스트
//     List<Long> result = new LinkedList<>();

//     // 주어진 이진 트리에서 경로 합이 targetSum과 일치하는 경로의 수를 반환
//     public int pathSum(TreeNode root, int targetSum) {
//         // 루트가 null이면, 경로가 없으므로 0 반환
//         if (root == null)
//             return 0;

//         // 깊이 우선 탐색(DFS) 실행
//         dfs(root);

//         // 타겟 합과 일치하는 경로의 수 계산
//         int targetCount = 0;
//         for (long pathSum : result) {
//             if (pathSum == targetSum)
//                 targetCount++;
//         }
//         return targetCount;
//     }

//     // 노드에서 시작하는 모든 경로의 합을 계산하는 깊이 우선 탐색
//     List<Long> dfs(TreeNode node) {
//         // 기저 조건: 노드가 null일 때, 빈 리스트 반환
//         if (node == null)
//             return new LinkedList<>();

//         // 왼쪽과 오른쪽 자식 노드에서 시작하는 경로의 합을 재귀적으로 계산
//         List<Long> leftPathSum = dfs(node.left);
//         List<Long> rightPathSum = dfs(node.right);

//         // 현재 노드에서 시작하는 모든 경로의 합을 저장할 리스트
//         List<Long> pathSum = new LinkedList<>();
//         // 왼쪽 및 오른쪽 경로의 합을 현재 리스트에 추가
//         pathSum.addAll(leftPathSum);
//         pathSum.addAll(rightPathSum);

//         // 현재 노드의 값을 각 경로 합에 추가
//         ListIterator<Long> iterator = pathSum.listIterator();
//         while (iterator.hasNext()) {
//             iterator.set(iterator.next() + node.val);
//         }
//         // 현재 노드 자체도 경로에 포함
//         pathSum.add((long) node.val);

//         // 계산된 경로의 합을 전역 결과 리스트에 추가
//         result.addAll(pathSum);

//         return pathSum;
//     }
// }

// Solution 2
// class Solution {
//     private int count = 0; // 타겟 합과 일치하는 경로의 수를 카운트합니다.
//     private int targetSum; // 타겟 합을 저장하는 변수입니다.

//     public int pathSum(TreeNode root, int targetSum) {
//         this.targetSum = targetSum; // 타겟 합 초기화
//         dfs(root, new ArrayList<>()); // DFS 시작
//         return count;
//     }

//     private void dfs(TreeNode node, List<Long> pathSums) {
//         if (node == null)
//             return; // 기저 조건

//         // 현재 경로까지의 모든 합을 업데이트하고 새 합을 추가합니다.
//         List<Long> newPathSums = new ArrayList<>();
//         for (long sum : pathSums) {
//             sum += node.val;
//             if (sum == targetSum)
//                 count++; // 업데이트된 합이 타겟 합과 일치하면 카운트 증가
//             newPathSums.add(sum);
//         }
//         // 현재 노드 값을 포함하는 새로운 합 추가
//         if (node.val == targetSum)
//             count++; // 노드 값 자체가 타겟 합과 일치하는 경우
//         newPathSums.add((long) node.val);

//         // 왼쪽, 오른쪽 자식 노드로 DFS 진행
//         dfs(node.left, newPathSums);
//         dfs(node.right, newPathSums);
//     }
// }

// Solution 3
class Solution {
    private int count = 0;
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        dfs(root, 0, new long[1000], 0); // 초기 깊이와 누적 합 배열
        return count;
    }

    private void dfs(TreeNode node, long currentSum, long[] sums, int level) {
        if (node == null)
            return;

        // 현재 경로의 누적 합 계산
        currentSum += node.val;

        // 루트에서 현재 노드까지의 경로에서 타겟 합과 일치하는지 확인
        if (currentSum == targetSum) {
            count++;
        }

        // 이전 경로의 합에서 현재 경로 합을 빼서 타겟 합과 일치하는 경우가 있는지 확인
        for (int i = 0; i < level; i++) {
            if (currentSum - sums[i] == targetSum) {
                count++;
            }
        }

        // 현재 경로의 합을 저장
        sums[level] = currentSum;

        // 왼쪽과 오른쪽 자식 노드 탐색
        dfs(node.left, currentSum, sums, level + 1);
        dfs(node.right, currentSum, sums, level + 1);
    }
}
