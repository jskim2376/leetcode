class Solution {
    public boolean increasingTriplet(int[] nums) {
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE, k = Integer.MAX_VALUE;
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] < nums[index + 1]) {
                k = nums[index + 1];
                if (i < k && j < k)
                    return true;
                i = nums[index];
                j = nums[index + 1];
            }
            if (i < nums[index + 1])
                j = nums[index + 1];
        }
        return false;
    }
}