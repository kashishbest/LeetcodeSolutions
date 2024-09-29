package org.example.hundred;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        List<int[]> input = new ArrayList<>();
        while (i < intervals.length) {
            if (intervals[i][0] > newInterval[0]) {
                break;
            }
            i++;
        }
        boolean added = false;
        while (j < intervals.length) {
            if (j == i && !added) {
                input.add(newInterval);
                added = true;
                continue;
            }
            input.add(intervals[j]);
            j++;
        }
        if (!added) {
            input.add(newInterval);
        }
        if (input.size() == 0) {
            list.add(newInterval);
            return list.toArray(new int[list.size()][]);
        }
        int[] temp = input.get(0);
        for (i = 1; i < input.size(); i++) {
            if (temp[1] < input.get(i)[0]) {
                list.add(temp);
                temp = input.get(i);
            } else {
                temp[0] = Math.min(temp[0], input.get(i)[0]);
                temp[1] = Math.max(temp[1], input.get(i)[1]);
            }
        }
        list.add(temp);
        return list.toArray(new int[list.size()][]);
    }
}
