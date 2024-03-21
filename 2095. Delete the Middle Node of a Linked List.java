/*
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
*/

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode originalHead = head;
        ListNode middleLeft = new ListNode(0, head);
        head = head.next;
        int n = 2;
        while (head != null) {
            if (n % 2 == 0) {
                middleLeft = middleLeft.next;
            }
            head = head.next;
            n++;
        }

        middleLeft.next = middleLeft.next.next;
        return originalHead;
    }
}