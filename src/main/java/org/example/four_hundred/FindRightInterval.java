package org.example.four_hundred;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/find-right-interval/
 */
public class FindRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<int[], Integer> map = new TreeMap<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1]-o2[1]:o1[0]-o2[0];
            }
        });

        for(int i = 0; i<intervals.length;i++) {
            map.put(intervals[i],i);
        }

        for(int i = 0; i<intervals.length;i++) {
            Map.Entry<int[],Integer> entry = map.ceilingEntry(new int[] {intervals[i][1],intervals[i][1]});
            result[i] =  entry == null ? -1:entry.getValue();
        }
        return result;
    }


}
