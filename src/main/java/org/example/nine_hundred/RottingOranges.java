package org.example.nine_hundred;

import java.util.*;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        int time = 0;
        Queue<Pair> next;
        Set<Pair> set = new HashSet<>();
        while (!queue.isEmpty()) {
            next = new LinkedList<>();
            int done = 0;
            while (!queue.isEmpty()) {
                Pair o = queue.poll();
                // if(grid[o.r][o.c] == 2) continue;
                grid[o.r][o.c] = 2;

                for (int[] direction : directions) {
                    int r = o.r + direction[0];
                    int c = o.c + direction[1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                        Pair temp = new Pair(o.r + direction[0], o.c + direction[1]);
                        if (set.contains(temp)) continue;
                        next.add(temp);
                        set.add(temp);
                    }
                }
            }
            if (!next.isEmpty()) time++;
            queue = next;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }

    class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return r == pair.r && c == pair.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

    }
}
