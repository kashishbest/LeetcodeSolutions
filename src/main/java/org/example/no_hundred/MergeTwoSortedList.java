package org.example.no_hundred;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode prev = new ListNode(-1);
        ListNode node = prev;
        while(list1!=null || list2!=null) {
            int list1Val = list1 != null ? list1.val : Integer.MAX_VALUE;
            int list2Val = list2 != null ? list2.val : Integer.MAX_VALUE;

            if(list1Val > list2Val) {
                node.next = list2;
                node = list2;
                list2 = list2.next;
            } else {
                node.next = list1;
                node = list1;
                list1 = list1.next;
            }
        }
        return prev.next;
    }
}
