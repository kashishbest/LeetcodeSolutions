package org.example.hundred;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return Collections.EMPTY_LIST;
        Map<Character, List<Character>> map = Map.ofEntries(
                Map.entry('2', Arrays.asList('a', 'b', 'c')),
                Map.entry('3', Arrays.asList('d', 'e', 'f')),
                Map.entry('4', Arrays.asList('g', 'h', 'i')),
                Map.entry('5', Arrays.asList('j', 'k', 'l')),
                Map.entry('6', Arrays.asList('m', 'n', 'o')),
                Map.entry('7', Arrays.asList('p', 'q', 'r', 's')),
                Map.entry('8', Arrays.asList('t', 'u', 'v')),
                Map.entry('9', Arrays.asList('w', 'x', 'y', 'z'))
        );

        List<String> result = new ArrayList<>();
        helper(new StringBuilder(), digits,map,result);
        return result;
    }

    private void helper(StringBuilder sb, String digits,Map<Character, List<Character>> map, List<String> result) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        int index = sb.length();
        for(char ch : map.get(digits.charAt(index))) {
            sb.append(ch);
            helper(sb,digits,map,result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
