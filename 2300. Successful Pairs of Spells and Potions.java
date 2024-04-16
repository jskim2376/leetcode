class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int low = 0;
            int high = potions.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2; // (low+high)/2 대신 사용해 overflow 방지
                System.out.printf("low: %d, high: %d, mid: %d mul: %d\n", low, high, mid, spells[i] * potions[mid]);
                if (spells[i] * potions[mid] == success) {
                    result[i] = potions.length - mid;
                    break;
                } else if (spells[i] * potions[mid] > success) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            result[i] = potions.length - high;
            System.out.printf("p.len: %d, high: %d, result: %d\n", potions.length, high, result[i]);
        }
        return result;
    }
}