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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = getNum(l1) + getNum(l2);
        if (sum == 0) {
            return new ListNode(0);
        }
        
        ListNode sumNode = null, temp = null;
        while (sum > 0) {
            int rem = sum % 10;
            
            ListNode t = new ListNode(rem);
            if (sumNode == null) {
                sumNode = temp = t;
            } else {
                temp.next = t;
                temp = t;
            }

            sum /= 10;
        }

        return sumNode;
    }

    private int getNum(ListNode head) {
        int num = 0;

        ListNode temp = head;
        int tens = 1;
        while (temp != null) {
            num += (tens * temp.val);
            tens *= 10;
            temp = temp.next;
        }

        return num;
    }
}
