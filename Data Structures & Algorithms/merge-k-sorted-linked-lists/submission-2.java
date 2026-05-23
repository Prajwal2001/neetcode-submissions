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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n == 0) {
            return null;
        }

        ListNode head = lists[0];
        for (int i = 1; i < n; i++) {
            head = merge(head, lists[i]);
        }

        return head;
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, temp = null, temp1 = l1, temp2 = l2;

        while (temp1 != null && temp2 != null) {
            ListNode t = null;
            if (temp1.val <= temp2.val) {
                t = temp1;
                temp1 = temp1.next;
            } else {
                t = temp2;
                temp2 = temp2.next;
            }
            
            if (head == null) {
                head = temp = t;
            } else {
                temp.next = t;
                temp = t;
            }
        }

        if (temp1 != null) {
            if (head == null) {
                return temp1;
            }
            temp.next = temp1;
        }

        if (temp2 != null) {
            if (head == null) {
                return temp2;
            }
            temp.next = temp2;
        }

        return head;
    }
}
