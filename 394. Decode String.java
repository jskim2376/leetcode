import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        Stack<int[]> stack = new Stack<>();
        int repeatedLeft = -1;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            // reapted가 여러 자리 일 수 있으니 숫자의 왼쪽 위치를 기억
            if (Character.isDigit(character)) {
                if (repeatedLeft == -1) {
                    repeatedLeft = i;
                }
                // '[' 가 나오면 repeated를 구함
            } else if (character == '[') {
                int repeatedRight = i;
                int repeated = Integer.parseInt(s.substring(repeatedLeft, repeatedRight));
                // encoded_string 왼쪽 위치를 구하고, repeated와 왼쪽 위치를 push
                int encodedStringLeft = result.length();
                stack.push(new int[] { repeated, encodedStringLeft });
                repeatedLeft = -1;
            } else if (character == ']') {
                // encoded_string을 인코딩된 문자열을 repeated 만큼 반복
                int[] repeatedAndLeft = stack.pop();
                int left = repeatedAndLeft[1];
                int right = result.length();

                String encodedString = result.substring(left, right);
                int repeated = repeatedAndLeft[0];
                for (int j = 0; j < repeated - 1; j++) {
                    result.append(encodedString);
                }
                // 일반문자열이면 결과에 더함
            } else {
                result.append(character);
            }
        }

        return result.toString();
    }
}