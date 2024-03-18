import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int numberLeft = -1;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (Character.isDigit(character)) {
                if (numberLeft == -1) {
                    numberLeft = i;
                }
            } else if (character == '[') {
                stack.push(new int[] { Integer.parseInt(s.substring(numberLeft, i)), result.length() });
                numberLeft = -1;
            } else if (character == ']') {
                int[] countAndLeft = stack.pop();
                int count = countAndLeft[0];
                int left = countAndLeft[1];
                int right = result.length();
                for (int j = 0; j < count - 1; j++) {
                    result.append(result.substring(left, right));
                }
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}