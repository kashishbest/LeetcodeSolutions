package org.example.hundred;

public class LongestPallindromicSubstirng {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            int temp = expandAroundCentre(s,i);

            if(maxLen < temp) {
                maxLen = temp;
                result = s.substring(i-((temp-1)/2),i+((temp+1)/2));
            }

        }
        for(int i = 0; i < s.length()-1; i++) {
            int temp = expandAround2Centre(s,i);
            if(maxLen < temp) {
                maxLen = temp;
                result = s.substring(i-((temp-1)/2),i+(temp/2)+1);
            }
        }
        return result;
    }

    int expandAroundCentre(String s, int index) {
        int left = index-1;
        int right = index+1;
        int result = 1;

        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) result+=2;
        return result;
    }
    int expandAround2Centre(String s, int index) {
        int left = index-1;
        int right = index+2;
        int result = 2;
        if(s.charAt(index) != s.charAt(index+1)) return 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) result+=2;
        return result;
    }
}
