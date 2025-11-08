package org.example.eight_hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MostProfitAssigningWork {
    class Task {
        int difficulty;
        int profit;

        public Task(int difficulty, int profit) {
            this.difficulty = difficulty;
            this.profit = profit;
        }
    }
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Task> tasks = new ArrayList<>();
        for(int i = 0; i < difficulty.length; i++) {
            tasks.add(new Task(difficulty[i],profit[i]));
        }
        tasks.sort(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.profit-o2.profit;
            }
        });
        Arrays.sort(worker);
        int i = tasks.size()-1;
        int j = worker.length-1;
        int result = 0;
        while(i >=0 && j >= 0) {
            Task t = tasks.get(i);
            while(j >= 0 && worker[j] >= t.difficulty) {
                j--;
                result += t.profit;
            }
            i--;
        }
        return result;
    }

    public static void main(String[] args) {
        MostProfitAssigningWork o = new MostProfitAssigningWork();
        System.out.println(o.maxProfitAssignment(new int[] {2,4,6,8,10}, new int[] {10,20,30,40,50},new int[] {4,5,6,7}));
    }
}
