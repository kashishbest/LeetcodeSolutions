package org.example.hundred;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] stats = new int[255];

        int right = 0;
        int left = 0;
        int ans = 0;
        while(right < s.length()) {


            while(right < s.length() && isValid(stats)) {
                ans = Math.max(ans,right-left);
                stats[s.charAt(right++)]++;
            }

            if(right == s.length() && isValid(stats))
                ans = Math.max(ans,right-left);

            while(left < right && !isValid(stats)) {
                stats[s.charAt(left++)]--;
            }
        }
        ans = Math.max(ans,right-left);
        return ans;

    }

    boolean isValid(int[] stats) {
        for( int n : stats) {
            if( n ==2) {
                return false;
            }
        }
        return true;
    }
}
