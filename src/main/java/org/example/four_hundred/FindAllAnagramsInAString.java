package org.example.four_hundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) return Collections.EMPTY_LIST;

        int[] actual = new int[26];
        int[] candidate = new int[26];
        List<Integer> result = new ArrayList<>();
        ;
        for (char c : p.toCharArray()) {
            actual[c - 97]++;
        }
        int i;
        for (i = 0; i < p.length(); i++) {
            char c = s.charAt(i);
            candidate[c - 97]++;
        }
        i = p.length();
        int j = 0;
        if (isAnagram(actual, candidate)) result.add(0);
        while (i < s.length()) {
            char c = s.charAt(i++);
            candidate[c - 97]++;
            c = s.charAt(j++);
            candidate[c - 97]--;
            if (isAnagram(actual, candidate)) result.add(j);
        }
        return result;
    }

    private boolean isAnagram(int[] actual, int[] candidate) {
        for (int i = 0; i < 26; i++) {
            if (actual[i] != candidate[i])
                return false;
        }
        return true;
    }
}
