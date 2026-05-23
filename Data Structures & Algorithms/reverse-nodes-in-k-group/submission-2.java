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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prevGrp = dummy;

        while (true) {
            ListNode kth = getKthNode(prevGrp.next, k);
            if (kth == null) {
                break;
            }
            
            ListNode nextGrp = kth.next;
            ListNode temp = prevGrp.next, prev = kth.next;

            while (temp != nextGrp) {
                ListNode t = temp.next;
                temp.next = prev;
                prev = temp;
                temp = t;
            }

            ListNode t = prevGrp.next;
            prevGrp.next = kth;
            prevGrp = t;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode head, int k) {
        while (head != null && k-- > 1) {
            head = head.next;
        }
        return head;
    }
}
