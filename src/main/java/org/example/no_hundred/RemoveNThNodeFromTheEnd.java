package org.example.no_hundred;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNThNodeFromTheEnd {

  public ListNode removeNthFromEnd(ListNode head, int n) {

    if(head == null) return null;
    ListNode node = head;
    int count = 0;
    while (count < n) {
      node = node.next;
      count++;
    }
    ListNode curr = head;
    ListNode prev = null;
    while(node != null) {
      node = node.next;
      prev = curr;
      curr = curr.next;
    }
    if(prev == null) {
      return head.next;
    }
    prev.next = curr.next;
    return head;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
