import java.util.ArrayList;
import java.util.List;

class Solution {
    int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 1부터 9까지의 숫자 배열

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combination(result, new ArrayList<>(), 0, k, n, 0);
        return result;
    }

    private void combination(List<List<Integer>> combinations, List<Integer> currentCombination, int index, int k,
            int n, int sum) {
        if (currentCombination.size() == k && sum == n) { // k개의 숫자가 사용되고, 합이 n과 같은 경우
            combinations.add(new ArrayList<>(currentCombination)); // 결과 리스트에 추가
            return;
        }

        for (int i = index; i < numbers.length; i++) {
            if (sum + numbers[i] <= n) { // 현재 숫자를 추가했을 때 합이 n을 초과하지 않는 경우
                currentCombination.add(numbers[i]); // 숫자 추가
                combination(combinations, currentCombination, i + 1, k, n, sum + numbers[i]); // 재귀 호출
                currentCombination.remove(currentCombination.size() - 1); // 마지막 요소 제거 (백트래킹)
            }
        }
    }
}
