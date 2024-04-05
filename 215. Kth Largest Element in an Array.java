// import java.util.Collections;
// import java.util.PriorityQueue;

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         var pq = new PriorityQueue<Integer>(Collections.reverseOrder());

//         for (int num : nums) {
//             pq.add(num);
//         }

//         int result = 0;
//         for (int i = 0; i < k; i++) {
//             result = pq.poll();
//         }

//         return result;
//     }
// }

class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pivotIndex = partion(nums, left, right);

            // 탐색 범위를 줄인다
            if (k == pivotIndex)
                return nums[k];
            else if (k < pivotIndex)
                right = pivotIndex - 1;
            else
                left = pivotIndex + 1;
        }
        return -1;
    }

    int partion(int[] nums, int left, int right) {
        swap(nums, left, new Random().nextInt(right - left + 1) + left);
        int pivotIndex = left;
        int pivot = nums[pivotIndex];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot)
                swap(nums, i, ++pivotIndex);
        }
        swap(nums, left, pivotIndex);

        return pivotIndex;
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
