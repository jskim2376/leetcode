public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2; // (low+high)/2 대신 사용해 overflow 방지
            int result = guess(mid);

            if (result == 0) {
                return mid; // 정답을 찾은 경우
            } else if (result == -1) {
                high = mid - 1; // 중간값보다 작은 경우
            } else {
                low = mid + 1; // 중간값보다 큰 경우
            }
        }
        return -1; // 이 부분은 실행되지 않습니다. 반복문 내에서 반드시 값을 반환합니다.
    }
}
