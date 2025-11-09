package org.example.two_hundred;

/**
 * https://leetcode.com/problems/paint-house-ii/description/
 */
public class PaintHouseII {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int k = costs[0].length;
        int n = costs.length;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < k; j++) {
                int mini = Integer.MAX_VALUE;
                for (int m = 0; m < k; m++) {
                    if (m == j) continue;
                    mini = Math.min(mini, costs[i + 1][m]);
                }
                costs[i][j] += mini;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            result = Math.min(result, costs[0][i]);
        }
        return result;
    }
}
