import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> occurrences = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!occurrences.containsKey(arr[i])){
                occurrences.put(arr[i], 1);
            }
            else{
                occurrences.put(arr[i], occurrences.get(arr[i])+1);
            }
        }
        Collection<Integer> value = occurrences.values();
        if(value.size() == value.stream().distinct().count()){
            return true;
        }
        return false;
    }
}