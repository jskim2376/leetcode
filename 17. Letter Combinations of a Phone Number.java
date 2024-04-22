import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] KEYPAD = {
            "", // 0
            "", // 1
            "abc", // 2
            "def", // 3
            "ghi", // 4
            "jkl", // 5
            "mno", // 6
            "pqrs", // 7
            "tuv", // 8
            "wxyz" // 9
    };

    private void backtrack(List<String> results, StringBuilder current, String digits, int index) {
        if (index == digits.length()) {
            results.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0'; // Convert char to digit
        String letters = KEYPAD[digit];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(results, current, digits, index + 1);
            current.deleteCharAt(current.length() - 1); // Remove last character to backtrack
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return results;
        }
        backtrack(results, new StringBuilder(), digits, 0);
        return results;
    }

}