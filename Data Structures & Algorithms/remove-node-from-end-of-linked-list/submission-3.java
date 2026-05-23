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
        int cnt = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }

        if (cnt == 1) {
            return null;
        }

        cnt -= n;
        if (cnt == 0) {
            return head.next;
        }
        temp = head;
        ListNode prev = null;
        while (cnt > 0) {
            prev = temp;
            temp = temp.next;
            cnt--;
        }

        prev.next = temp.next;

        return head;
    }
}
