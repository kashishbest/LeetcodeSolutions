package org.example.no_hundred;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodeInPairs {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        ListNode result = new ListNode(-1,head);
        ListNode prev = result;
        ListNode curr = head;
        ListNode next = curr.next;
        while(curr!= null && next != null) {

            prev.next = next;
            ListNode temp = next.next;
            curr.next = temp;
            next.next= curr;
            prev = curr;
            curr = curr.next;
            next = curr == null ? null : curr.next;
        }
        return result.next;
    }
}
