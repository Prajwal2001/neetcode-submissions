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
    public void reorderList(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null, cur = slow.next;
        while (cur != null) {
            ListNode t = cur.next;
            cur.next = prev;
            prev = cur;
            cur = t;
        }
        slow.next = null;


        ListNode temp1 = head, temp2 = prev;
        int cnt = 0;
        while (temp1 != null && temp2 != null) {
            ListNode t1 = temp1.next;
            ListNode t2 = temp2.next;
            temp1.next = temp2;
            temp2.next = t1;
            temp1 = t1;
            temp2 = t2;
        }
    }
}
