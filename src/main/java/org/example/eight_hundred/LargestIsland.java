package org.example.eight_hundred;

import java.util.*;

/**
 * https://leetcode.com/problems/making-a-large-island/description/
 */
public class LargestIsland {
    public int largestIsland(int[][] grid) {
        Map<Integer,Integer> sizes = findIslands(grid);
        if(sizes.size() == 0) return 1;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int answer = Collections.max(sizes.values());
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                Set<Integer> set = new HashSet<>();
                if(grid[i][j] == 0) {
                    for(int[] direction : directions) {
                        int[] newPoint = new int[] {i+direction[0],j+direction[1]};
                        if(newPoint[0] < 0 || newPoint[0] >= grid.length || newPoint[1] < 0 || newPoint[1] >= grid[0].length)
                            continue;
                        if(grid[newPoint[0]][newPoint[1]] != 0) {
                            set.add(grid[newPoint[0]][newPoint[1]]);
                        }
                    }
                }
                int temp = 1;
                for(Integer island : set) {
                    temp += sizes.get(island);
                }
                answer = Math.max(temp,answer);
            }
        }
        return answer;

    }

    private Map<Integer,Integer> findIslands(int[][] grid) {
        Map<Integer,Integer> sizes = new HashMap<>();
        int islandId = 2;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    sizes.put(islandId,exploreIsland(grid,new int[] {i,j}, islandId));
                    islandId++;
                }
            }
        }
        return sizes;
    }

    private int exploreIsland(int[][] grid,int[] start, int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int count = 0;
        while(!queue.isEmpty()) {
            int[] point = queue.remove();
            if(grid[point[0]][point[1]] != 1) continue;
            grid[point[0]][point[1]] = islandId;
            count++;

            for(int[] direction : directions) {
                int[] newPoint = new int[] {point[0]+direction[0],point[1]+direction[1]};
                if(newPoint[0] < 0 || newPoint[0] >= grid.length || newPoint[1] < 0 || newPoint[1] >= grid[0].length)
                    continue;
                if(grid[newPoint[0]][newPoint[1]] == 1) {
                    queue.add(newPoint);
                }
            }
        }
        return count;
    }
}
