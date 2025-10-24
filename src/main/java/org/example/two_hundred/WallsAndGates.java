package org.example.two_hundred;

import java.util.*;

/**
 * https://leetcode.com/problems/walls-and-gates/description/
 */
public class WallsAndGates {
    class Pair {
        int[] point;

        public Pair(int[] point, int distance) {
            this.point = point;
            this.distance = distance;
        }

        int distance;
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Pair> queue = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        int[][] directions = new int[][] { {1,0},{0,1},{-1,0},{0,-1}};
        queue.addAll(findGates(rooms));
        while(!queue.isEmpty()) {
            Pair current = queue.remove();
            rooms[current.point[0]][current.point[1]] = Math.min(current.distance,rooms[current.point[0]][current.point[1]]);
            for(int[] direction : directions) {
                int[] newPoint = new int[] {current.point[0] + direction[0], current.point[1] + direction[1]};
                if(newPoint[0] < 0 || newPoint[0] >= rooms.length || newPoint[1] < 0 || newPoint[1] >= rooms[0].length)
                    continue;
                if(rooms[newPoint[0]][newPoint[1]] == Integer.MAX_VALUE) {
                    queue.add(new Pair(newPoint,current.distance+1));
                }
            }
        }
    }

    List<Pair> findGates(int[][] rooms) {
        List<Pair> gates= new ArrayList<>();
        for(int i = 0; i < rooms.length; i++) {
            for ( int j= 0; j < rooms[i].length; j++) {
                if(rooms[i][j] == 0)
                    gates.add(new Pair(new int[] {i,j},0));
            }
        }

        return gates;
    }
}
