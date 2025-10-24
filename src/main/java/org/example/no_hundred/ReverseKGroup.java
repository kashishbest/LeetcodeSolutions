package org.example.no_hundred;

import java.util.List;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseKGroup {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1, head);
        ListNode previous = dummy;
        ListNode start = head;
        ListNode curr = head;
        ListNode next = head.next;
        int count = 1;
        while (curr != null) {
            while (count != k && next != null) {
                count++;
                curr = next;
                next = next.next;
            }

            if (count != k)
                break;
            reverse(previous, start, curr, next);
            previous = start;
            count = 1;
            start = next;
            curr = next;
            next = next != null ? next.next : null;

        }
        return dummy.next;
    }

    void reverse(ListNode previous, ListNode start, ListNode end, ListNode next) {

        ListNode prev = null;
        ListNode curr = start;
        ListNode nextNode = curr.next;
        while (curr != end) {
            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        curr.next = prev;

        previous.next = end;
        start.next = next;

    }

    public static void main(String[] args) {
        ReverseKGroup kGroup = new ReverseKGroup();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4,l1);
        ListNode l3 = new ListNode(3,l2);
        ListNode l4 = new ListNode(2,l3);
        ListNode l5 = new ListNode(1,l4);
        ListNode answer = kGroup.reverseKGroup(l5,2);
        while(answer != null) {
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
        System.out.println();
        answer = kGroup.reverseKGroup(l5,3);
        while(answer != null) {
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
        System.out.println();
        answer = kGroup.reverseKGroup(l5,1);
        while(answer != null) {
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
        System.out.println();
        answer = kGroup.reverseKGroup(l5,5);
        while(answer != null) {
            System.out.print(answer.val + " ");
            answer = answer.next;
        }
    }
}
