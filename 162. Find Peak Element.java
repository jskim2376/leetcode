class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1; // 피크가 mid+1 이후에 있다고 판단
            } else {
                right = mid; // 피크가 mid 이하에 있다고 판단
            }
        }
        //// 반복문이 종료되면 left와 right는 같은 위치를 가리키며, 이 위치는 피크의 인덱스임
        return left;
    }

}