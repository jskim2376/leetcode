import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // 우측으로 이동하는 경우는 그냥 스택에 넣음
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                // 스택에 있는 우측으로 이동 중인 로봇들을 모두 처리
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }
                // 충돌이 발생하지 않는 경우
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                } else if (stack.peek() == Math.abs(asteroid)) { // 크기가 같은 경우
                    stack.pop();
                }
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}