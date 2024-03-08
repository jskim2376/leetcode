import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        List<List<Integer>> answer = new ArrayList<>();
        answer.add(num1Set.stream().filter(e -> !num2Set.contains(e)).collect(Collectors.toList()));
        answer.add(num2Set.stream().filter(e -> !num1Set.contains(e)).collect(Collectors.toList()));

        return answer;
    }
}