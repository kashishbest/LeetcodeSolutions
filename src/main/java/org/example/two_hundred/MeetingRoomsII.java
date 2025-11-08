package org.example.two_hundred;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        int solution = 0;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        for (int[] interval : intervals) {
            while (pq.size() > 0 && isOverlap(pq.peek(), interval)) pq.poll();
            pq.add(interval);
            solution = Math.max(solution, pq.size());
        }
        return solution;
    }

    boolean isOverlap(int[] interval1, int[] interval2) {
        return interval1[1] <= interval2[0];
    }
}
