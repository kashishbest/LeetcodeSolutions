package org.example.hundred;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;//-1
        ListNode node = head;//3
        // [-1,1,2,3,3,4,4,5]
        while (node != null) {
            int count = 0;
            int currNum = node.val;//2
            ListNode temp = node;//2
            while (node != null && node.val == currNum) {
                temp = node;
                node = node.next;
                count++;
            }
            if (count == 1) {
                prev.next = temp;
                prev = prev.next;
                prev.next = null;
            }

        }
        return dummy.next;
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
