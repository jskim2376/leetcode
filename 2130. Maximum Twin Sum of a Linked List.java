class Solution {
    public int pairSum(ListNode head) {
        Deque<Integer> values = new ArrayDeque<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int max = 0;
        while (values.size() != 0) {
            max = Math.max(max, values.removeFirst() + values.removeLast());
        }
        return max;
    }
}

// class Solution {
// public int pairSum(ListNode head) {
// int[] values = new int[100000];
// int n = 0;
// while (head != null) {
// values[n] = head.val;
// head = head.next;
// n++;
// }

// int max = 0;
// for (int i = 0; i <= (n / 2) - 1; i++) {
// int sum = values[i] + values[(n - 1 - i)];
// max = Math.max(max, sum);
// }

// return max;
// }
// }