package org.example.no_hundred;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode soln = new ListNode(-1);
        ListNode node = soln;
        while(l1 != null || l2 != null) {
            int top = l1 == null ? 0: l1.val;
            int bottom = l2 == null ? 0: l2.val;

            int sum = top + bottom + carry;
            ListNode temp = new ListNode(sum % 10);
            node.next= temp;
            node = temp;
            carry = sum/10;
            l1 = l1 == null? l1 : l1.next;
            l2 = l2 == null? l2 : l1.next;
        }
        if(carry >  0) {
            ListNode temp = new ListNode(carry);
            node.next = temp;
        }

        return soln.next;
    }
}
