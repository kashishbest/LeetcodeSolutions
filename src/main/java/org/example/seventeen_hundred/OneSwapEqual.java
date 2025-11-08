package org.example.seventeen_hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class OneSwapEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        List<Integer> indexes = new ArrayList<>();

        for(int i =0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(i)) continue;
            indexes.add(i);
            if(indexes.size() > 2) return false;
        }
        if(indexes.size() == 1) return false;
        if(indexes.size() == 0) return true;
        return (s1.charAt(indexes.get(0)) == s2.charAt(indexes.get(1))) && (s1.charAt(indexes.get(1)) == s2.charAt(indexes.get(0)));
    }
}
