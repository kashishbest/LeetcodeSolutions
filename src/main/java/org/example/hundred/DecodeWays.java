package org.example.hundred;

public class DecodeWays {
    /**
     * https://leetcode.com/problems/decode-ways/description/
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 0; i<s.length(); i++) {

            int oneDigit = Integer.parseInt(s.substring(i,i+1));
            int twoDigit = 0;
            if(i > 0) twoDigit = Integer.parseInt(s.substring(i-1,i+1));

            if(oneDigit > 0 && oneDigit < 10) {
                dp[i+1] = dp[i];
            }

            if(twoDigit > 9 && twoDigit < 27) {
                dp[i+1] += dp[i-1];
            }

            if(dp[i+1] == 0) return 0;
        }
        return dp[s.length()];
    }
}
