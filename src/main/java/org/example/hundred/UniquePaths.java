package org.example.hundred;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + dp[i - 1][j]);
            }
        }
        return dp[m][n];
    }
}
