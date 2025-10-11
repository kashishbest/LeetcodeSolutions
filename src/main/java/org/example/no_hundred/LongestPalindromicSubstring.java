package org.example.no_hundred;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class LongestPalindromicSubstring {
    class Pair {
        int l,r;

        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public String longestPalindrome(String s) {
        int soln = 0;
        Pair solnPair = new Pair(0,0);
        for(int i = 0; i < s.length(); i++) {
            Pair temp = expandAroundCentre(s,i);
            if(temp.r-temp.l+1 > soln) {
                soln = temp.r-temp.l+1;
                solnPair = temp;
            }
            if(i+1 < s.length()) {
                temp = expandAround2Centre(s,i);
                if(temp != null && temp.r-temp.l+1 > soln) {
                    soln = temp.r-temp.l+1;
                    solnPair = temp;
                }
            }
        }

        return s.substring(solnPair.l, solnPair.r+1);
    }

    Pair expandAroundCentre(String s, int i) {
        int left = i-1;
        int right = i+1;
        while( left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new Pair(left+1,right-1);
    }
    Pair expandAround2Centre(String s, int i) {
        if(s.charAt(i)!=s.charAt(i+1)) return null;
        int left = i-1;
        int right = i+2;
        while( left > 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return new Pair(left+1,right-1);
    }
}
