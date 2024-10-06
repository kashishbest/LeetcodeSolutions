package org.example.four_hundred;

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return false;
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) return false;

        int subSetSum = totalSum / 2;
        boolean dp[] = new boolean[subSetSum + 1];
        dp[0] = true;

        for (int curr : nums) {
            for (int j = subSetSum; j >= curr; j--) {
                dp[j] |= dp[j - curr];
            }
        }

        return dp[subSetSum];
    }
}
