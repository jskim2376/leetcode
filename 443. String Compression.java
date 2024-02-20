class Solution {
    public int compress(char[] chars) {
        StringBuffer s = new StringBuffer();
        int groupLength = 1;

        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1 && chars[i] == chars[i + 1]) {
                groupLength++;
            } else {
                s.append(chars[i]);
                if (groupLength != 1)
                    s.append(groupLength);
                groupLength = 1;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        return s.length();
    }
}