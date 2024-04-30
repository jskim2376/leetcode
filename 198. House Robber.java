class Solution {
    public int rob(int[] nums) {
        if (houseValues.length == 1) {
            return houseValues[0];
        }
        if (houseValues.length == 2) {
            return Math.max(houseValues[0], houseValues[1]);
        }

        int threeAgoMax = Integer.MIN_VALUE;
        int twoAgoMax = nums[0];
        int oneAgoMax = nums[1];

        for (int i = 2; i < nums.length; i++) { // start current
            int currentMax = nums[i] + Math.max(threeAgoMax, twoAgoMax);
            threeAgoMax = twoAgoMax;
            twoAgoMax = oneAgoMax;
            oneAgoMax = currentMax;
        }

        return Math.max(twoAgoMax, oneAgoMax);
    }
}
