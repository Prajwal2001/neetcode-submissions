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
        int size = 0;
        
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int cur = 0;
        ListNode prev = null; 
        temp = head;

        while (cur < size - n) {
            prev = temp;
            temp = temp.next;
            cur++;
        }

        if (prev == null && temp.next == null) {
            return null;
        } else if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }

        return head;
    }
}
