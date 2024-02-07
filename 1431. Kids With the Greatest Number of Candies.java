import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();

        int greatestNumber = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > greatestNumber) {
                greatestNumber = candies[i];
            }
        }

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= greatestNumber) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }
}