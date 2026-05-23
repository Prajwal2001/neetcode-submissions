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
        ListNode head = null, temp = null;

        for (ListNode node : lists) {

            if (head == null) {
                head = temp = node;
            } else {
                head = merge(head, node);
            }
            // print(node);
        }

        return head;
    }

    private void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = null, temp1 = l1, temp2 = l2, temp = null;

        while (temp1 != null && temp2 != null) {
            ListNode t = null;
            if (temp1.val < temp2.val) {
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

        print(head);

        if (temp1 != null) {
            if (head == null) {
                head = temp1;
            } else {
                temp.next = temp1;
            }
        }

        if (temp2 != null) {
            if (head == null) {
                head = temp2;
            } else {
                temp.next = temp2;
            }
        }

        return head;
    }
}
