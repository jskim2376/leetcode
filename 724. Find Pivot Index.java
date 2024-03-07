import java.util.Arrays;

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum() - nums[0];

        if (leftSum == rightSum)
            return 0;

        for (int i = 1; i < nums.length; i++) {
            leftSum += nums[i - 1];
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
        }

        return -1;
    }
}