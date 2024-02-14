import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String reverseVowels(String s) {
        String sLow = s.toLowerCase();
        Character[] vowels = new Character[] { 'a', 'e', 'i', 'o', 'u' };

        List<Integer> vowelsIndex = new ArrayList<>();
        for (int i = 0; i < sLow.length(); i++) {
            if (Arrays.asList(vowels).contains(sLow.charAt(i))) {
                vowelsIndex.add(i);
            }
        }

        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < vowelsIndex.size() / 2; i++) {
            int frontIndex = vowelsIndex.get(i);
            int backIndex = vowelsIndex.get(vowelsIndex.size() - 1 - i);

            char backChar = sb.charAt(backIndex);
            sb.setCharAt(backIndex, sb.charAt(frontIndex));
            sb.setCharAt(frontIndex, backChar);
        }

        return sb.toString();
    }
}