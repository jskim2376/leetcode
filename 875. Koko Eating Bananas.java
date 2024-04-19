import java.util.Arrays;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt(); // 배열 중 최댓값을 한 번만 계산합니다.

        while (left <= right) {
            int mid = (left + right) / 2;
            long k = 0;
            for (int p : piles) {
                k += (p + mid - 1) / mid; // 올림 계산을 효율적으로 수행
            }

            if (k <= h) {
                right = mid - 1; // k가 h 이하면 k를 줄여 더 작은 속도를 탐색
            } else {
                left = mid + 1; // k가 h보다 크면 k를 늘려야 하므로 더 큰 속도를 탐색
            }
        }

        return left; // 최소 k 값 반환
    }
}
