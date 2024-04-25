class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // 배열 크기가 2일 경우, 두 값 중 작은 값을 반환
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }

        // 마지막 두 요소로 초기화
        int secondLast = cost[cost.length - 2];
        int last = cost[cost.length - 1];

        // 마지막 세 번째 요소부터 순회 시작
        for (int i = cost.length - 3; i >= 0; i--) {
            int current = cost[i] + Math.min(secondLast, last);
            last = secondLast;
            secondLast = current;
        }

        // 최소 시작 비용 계산
        return Math.min(secondLast, last);
    }
}
