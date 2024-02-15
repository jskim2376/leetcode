class Solution {
    public String reverseWords(String s) {
        String[] sArray = s.strip().split(" +");

        StringBuffer sb = new StringBuffer();
        for (int i = sArray.length - 1; i > 0; i--) {
            sb.append(sArray[i]);
            sb.append(" ");
        }
        sb.append(sArray[0]);

        return sb.toString();
    }
}