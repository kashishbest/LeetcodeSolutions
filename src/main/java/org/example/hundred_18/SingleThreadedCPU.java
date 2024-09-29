package org.example.hundred_18;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/single-threaded-cpu/description/
 */
public class SingleThreadedCPU {
    public static int[] getOrder(int[][] tasks) {
        List<Node> taskObjects = IntStream.range(0, tasks.length).mapToObj(index -> new Node(tasks[index], index)).collect(Collectors.toList());
        int[] result = new int[tasks.length];
        Collections.sort(taskObjects, (a, b) -> a.data[0] - b.data[0]);
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) -> {
            if (a.data[1] == b.data[1]) return a.index - b.index;
            return a.data[1] - b.data[1];
        });
        int index = 0;
        int taskIndex = 0;
        int timeElapsed = 0;

        while (true) {
            if (heap.size() == 0) {
                if (taskIndex < tasks.length) {
                    heap.add(taskObjects.get(taskIndex));
                    timeElapsed = Math.max(timeElapsed,taskObjects.get(taskIndex++).data[0]);
                }

            }
            if (heap.size() == 0) break;
            while (taskIndex < tasks.length && taskObjects.get(taskIndex).data[0] <= timeElapsed) {
                heap.add(taskObjects.get(taskIndex++));
            }
            Node taskExecuted = heap.poll();
            result[index++] = taskExecuted.index;
            timeElapsed += taskExecuted.data[1];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getOrder(new int[][]{{1, 2}, {2, 4}, {3, 2}, {4, 1}})));
    }

    static class Node {
        int[] data;
        int index;

        public Node(int[] data, int index) {
            this.data = data;
            this.index = index;
        }
    }
}
