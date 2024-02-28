class Solution {
    public int maxVowels(String s, int k) {
        char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
        boolean[] vowelMap = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (char vowel : vowels) {
                if (s.charAt(i) == vowel) {
                    vowelMap[i] = true;
                    break;
                }
            }
        }

        int maxVowels = 0;
        int cntVowels = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= k && vowelMap[i - k]) {
                cntVowels--;
            }
            if (vowelMap[i]) {
                cntVowels++;
            }
            maxVowels = Math.max(maxVowels, cntVowels);
        }

        return maxVowels;
    }
}