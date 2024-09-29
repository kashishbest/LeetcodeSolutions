package org.example.hundred;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        int i = 1;
        boolean shouldReverse = false;
        ListNode node = head;
        ListNode leftPrev = null, leftNode = null;
        ListNode next;
        while (i <= right) {
            if (i == left) {
                leftPrev = prev;//1
                leftNode = node;//2
                shouldReverse = true;
            }

            if (shouldReverse) {
                next = node.next;//3
                node.next = prev;//2->1
                prev = node;//2
                node = next;//3
            } else {
                prev = node;
                node = node.next;
            }

            if (i == right) {
                leftPrev.next = prev;
                leftNode.next = node;
                shouldReverse = false;
                break;
            }
            i++;
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
