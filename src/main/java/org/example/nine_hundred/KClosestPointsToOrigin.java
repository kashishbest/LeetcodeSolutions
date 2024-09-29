package org.example.nine_hundred;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    class Node implements Comparable{
        int[] point;
        int distance;
        public Node(int[] pt) {
            this.point = pt;
            distance = pt[0] * pt[0] + pt[1]*pt[1];
        }

        @Override
        public int compareTo(Object obj) {
            Node temp = (Node)obj;
            return this.distance-temp.distance;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i<k; i++) {
            heap.add(new Node(points[i]));
        }

        for(int i = k; i<points.length; i++) {
            Node n = new Node(points[i]);
            if(heap.peek().distance > n.distance) {
                heap.poll();
                heap.add(n);
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!heap.isEmpty()) {
            result[i++] = heap.poll().point;
        }
        return result;
    }
}
