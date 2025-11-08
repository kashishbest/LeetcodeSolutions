package org.example.twelve_hundred;

import java.util.Arrays;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
 */
public class MaxProfitInJobScheduling {
        class Task implements Comparable {
            int start;
            int end;
            int profit;

            public Task(int start, int end, int profit) {
                this.start = start;
                this.end = end;
                this.profit = profit;
            }
            @Override
            public int compareTo(Object o) {
                Task t = (Task) o;
                // if(t.end == this.end) return this.start-t.start;
                return this.end-t.end;
            }
        }
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int soln = 0;

            Task[] tasks = new Task[startTime.length];
            for(int i = 0; i<startTime.length; i++) {
                tasks[i] = new Task(startTime[i],endTime[i],profit[i]);
            }

            Arrays.sort(tasks);
            NavigableMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
            map.put(0,0);
            for(Task task : tasks) {
                int maxProfitTillNow = map.floorEntry(task.end).getValue();
                int profitUntilThisTask = map.floorEntry(task.start).getValue();
                int currentProfit = Math.max(maxProfitTillNow, profitUntilThisTask+task.profit) ;
                map.put(task.end,  currentProfit);
                soln = Math.max(soln,currentProfit);
            }
            return soln;
        }

}
