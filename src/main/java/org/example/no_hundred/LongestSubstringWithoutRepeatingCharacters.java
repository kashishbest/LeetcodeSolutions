package org.example.no_hundred;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class LongestSubstringWithoutRepeatingCharacters {

    static boolean hasDuplicate(String str,int start, int end) {
        int[] chars = new int[255];

        for(int i = start; i <= end; i++) {
            char ch = str.charAt(i);
            if(chars[ch] == 1) return true;
            chars[ch]++;
        }
        return false;
    }

    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int soln = 0;

        while(right < s.length()) {
            while(right < s.length() && !hasDuplicate(s,left,right)) {
                right++;
            }
            soln = Math.max(soln,right-left);
            if(right == s.length()) {
                break;
            }
            while(left < right && hasDuplicate(s,left,right)) {
                left++;
            }

        }
        return soln;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("a"));
    }
    /**
             abcabcbb
             01234567
     i
     left    0
     right   3
     */
}
