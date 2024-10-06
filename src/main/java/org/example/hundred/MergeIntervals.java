package org.example.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                if (interval1[0] != interval2[0]) {
                    return Integer.compare(interval1[0], interval2[0]);
                } else {
                    return Integer.compare(interval1[1], interval2[1]);
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] < intervals[i][0]) {
                result.add(interval);
                interval = intervals[i];
            } else {
                interval[0] = Math.min(interval[0], intervals[i][0]);
                interval[1] = Math.max(interval[1], intervals[i][1]);
            }
        }
        result.add(interval);


        return result.toArray(new int[result.size()][]);
    }
}
