package org.example.no_hundred;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(true) {
            if( index == strs[0].length())
                return sb.toString();
            char ch = strs[0].charAt(index);
            for(String str : strs) {
                if(index < str.length() && ch == str.charAt(index))
                    continue;
                return sb.toString();
            }
            sb.append(ch);
        }
    }
}
