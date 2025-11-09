package org.example.two_hundred;

/**
 * https://leetcode.com/problems/h-index-ii/description/
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }
}
