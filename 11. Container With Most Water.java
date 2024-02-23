class Solution {
    int amountOfWater(int[] height, int left, int right) {
        return height[left] > height[right] ? height[right] * (right - left) : height[left] * (right - left);
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxAmountOfWater = amountOfWater(height, left, right);

        while (left < right) {
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            maxAmountOfWater = Math.max(maxAmountOfWater, amountOfWater(height, left, right));
        }

        return maxAmountOfWater;
    }
}