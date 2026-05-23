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
        if (head.next == null || head.next.next == null) {
            return;
        }
        //Identify mid node
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //Reverse the second half of nodes
        ListNode midTemp = slow.next, midPrev = null;
        while (midTemp != null) {
            ListNode t = midTemp.next;
            midTemp.next = midPrev;
            midPrev = midTemp;
            midTemp = t;
        }
        slow.next = midPrev;
        slow.next = null;

        ListNode temp = head;
        midTemp = midPrev;

        while (midTemp != null) {
            ListNode t = temp.next; 
            ListNode mt = midTemp.next;
            temp.next = midTemp;
            midTemp.next = t;
            temp = t;
            midTemp = mt;
        }
    }

    private void print(ListNode head) {
        ListNode t1 = head;
        while (t1 != null) {
            System.out.println(t1.val);
            t1 = t1.next;
        }
    }
}
