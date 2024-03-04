class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int deleted = 0;
        int beforetZeroPosition = -1;
        int maxResult = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                deleted++;
                if (beforetZeroPosition < 0) {
                    beforetZeroPosition = right;
                }
            }
            right++;

            if (deleted > 1) {
                deleted--;
                left = beforetZeroPosition + 1;
                beforetZeroPosition = right;
            }

            maxResult = Math.max(maxResult, right - left);
        }

        return maxResult;
    }
}