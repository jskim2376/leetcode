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