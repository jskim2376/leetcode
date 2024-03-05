class Solution {
    public int largestAltitude(int[] gain) {
        int maxSum = 0;
        int prefixSum = 0;

        for (int i = 0; i < gain.length; i++) {
            prefixSum += gain[i];
            maxSum = Math.max(maxSum, prefixSum);
        }

        return maxSum;
    }
}