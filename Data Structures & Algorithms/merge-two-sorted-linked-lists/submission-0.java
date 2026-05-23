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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        ListNode res = null, head = null;

        while (t1 != null && t2 != null) {
            ListNode t;
            if (t1.val < t2.val) {
                t = t1;
                t1 = t1.next;
            } else {
                t = t2;
                t2 = t2.next;
            }

            if (head == null) {
                head = res = t;
            } else {
                res.next = t;
                res = t;
            }
        }

        while (t1 != null) {
            if (head == null) {
                head = res = t1;
            } else {
                res.next = t1;
                res = t1;
            }
            t1 = t1.next;
        }

        while (t2 != null) {
            if (head == null) {
                head = res = t2;
            } else {
                res.next = t2;
                res = t2;
            }
            t2 = t2.next;
        }

        return head;
    }
}