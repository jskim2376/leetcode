class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxConsentiveOne = 0;
        int left = 0;
        int right = 0;
        int remainK = k;

        while (right < nums.length) {
            if (k == 0 && nums[left] == 0) {
                left++;
            }
            if (nums[right] == 0) {
                if (remainK != 0) {
                    remainK--;
                } else {
                    while (left < right) {
                        if (nums[left] == 0) {
                            left++;
                            break;
                        }
                        left++;
                    }
                }
            }

            maxConsentiveOne = Math.max(maxConsentiveOne, right - left + 1);
            right++;
        }

        return maxConsentiveOne;
    }
}