class Solution {
    public String removeStars(String s) {
        StringBuffer solution = new StringBuffer();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '*'){
                solution.setLength(solution.length()-1);
            }
            else{
                solution.append(s.charAt(i));
            }
        }

        return solution.toString();
    }
}