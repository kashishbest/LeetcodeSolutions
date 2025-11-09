package org.example.three_hundred;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *  https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallestElementInAsortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for(int i = 0; i < matrix.length; i++) {
            heap.add(new int[]{matrix[i][0], i, 0});
        }

        int result=0;
        while(k>0 && !heap.isEmpty()) {
            int[] arr = heap.poll();
            result = arr[0];
            if(arr[2]+1 < matrix[0].length) heap.add(new int[] {matrix[arr[1]][arr[2]+1], arr[1],arr[2]+1});
            k--;
        }
        return result;
    }

}
