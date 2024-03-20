import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Character> deque = senate.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int radiantBanCount = 0;
        int direBanCount = 0;
        while (radiantBanCount != deque.size() && direBanCount != deque.size()) {
            Character c = deque.removeFirst();
            if (c == 'R') {
                if (direBanCount == 0) {
                    deque.addLast(c);
                    radiantBanCount++;
                } else {
                    direBanCount--;
                }
            } else {
                if (radiantBanCount == 0) {
                    deque.addLast(c);
                    direBanCount++;
                } else {
                    radiantBanCount--;
                }
            }
        }

        return (radiantBanCount > direBanCount) ? "Radiant" : "Dire";
    }
}
