package org.example.no_hundred;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 */
public class MergeKSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        ListNode result = new ListNode(-1);
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node : lists) {
            if(node != null) heap.add(node);
        }
        ListNode node =result;
        while(heap.size()!=0) {
            ListNode pop = heap.poll();
            node.next = pop;
            node = pop;
            if(pop.next != null)
                heap.add(pop.next);
        }
        return result.next;

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
