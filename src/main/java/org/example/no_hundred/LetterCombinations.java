package org.example.no_hundred;

import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
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
        helper(new StringBuilder(), digits, 0, map, result);
        return result;
    }
    private void helper(StringBuilder sb , String digits, int index, Map<Character, List<Character>> map, List<String> result) {

        if(index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for(Character ch : map.get(digits.charAt(index))) {
            sb.append(ch);
            helper(sb,digits,index+1, map, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations obj = new LetterCombinations();
        System.out.println(Arrays.toString(obj.letterCombinations("23").toArray()));
    }
}
