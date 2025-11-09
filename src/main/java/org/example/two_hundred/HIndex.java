package org.example.two_hundred;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/h-index/description/
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i) {
            i++;
        }
        return i;
    }

}
