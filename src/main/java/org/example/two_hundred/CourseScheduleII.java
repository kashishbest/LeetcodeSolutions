package org.example.two_hundred;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int[] pre : prerequisites) {
            if(!map.containsKey(pre[0])) {
                map.put(pre[0], new ArrayList<>());
            }
            map.get(pre[0]).add(pre[1]);
        }

        int[] result = new int[numCourses];
        int index = 0;

//        Queue<>

        return result;
    }
}
