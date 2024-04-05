import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        int result = 0;
        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }

        return result;
    }
}