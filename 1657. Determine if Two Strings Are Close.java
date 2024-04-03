import java.util.stream.Collectors;
import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())
            return false;

        Map<Character, Long> word1Map = word1.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        Map<Character, Long> word2Map = word2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Set<Character> word1CharSet = word1Map.keySet();
        Set<Character> word2CharSet = word2Map.keySet();
        if (!word1CharSet.equals(word2CharSet))
            return false;

        List<Long> values1 = word1Map.values().stream().sorted().collect(Collectors.toList());
        List<Long> values2 = word2Map.values().stream().sorted().collect(Collectors.toList());
        if (!values1.equals(values2))
            return false;

        return true;
    }

}