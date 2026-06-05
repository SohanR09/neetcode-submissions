/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head, start = dummy;

        while (n > 0) {
            cur = cur.next;
            n--;
        }

        while (cur != null) {
            start = start.next;
            cur = cur.next;
        }

        start.next = start.next.next;
        return dummy.next;
    }
}
