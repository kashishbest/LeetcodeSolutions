package org.example.no_hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 */
public class ZigZagConversion {


    public String convert(String s, int numRows) {
        List<List<Character>> result = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            result.add(new ArrayList<Character>());
        }
        int index = 0;
        while(index < s.length()) {

            index = down(s,index,numRows,result);
            index = up(s,index,numRows,result);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(List<Character> list : result) {
            for (Character ch : list) {
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();

    }
    int down(String s, int index, int numRows, List<List<Character>> result) {

        for(int i = 0;i < numRows && index<s.length();index++,i++) {
            result.get(i).add(s.charAt(index));
        }
        return index;
    }
    int up(String s, int index, int numRows, List<List<Character>> result) {
        for(int i = numRows-2; i > 0 && index < s.length();i--,index++ ) {
            result.get(i).add(s.charAt(index));
        }
        return index;
    }

    public static void main(String[] args) {
        ZigZagConversion z = new ZigZagConversion();
        System.out.println(z.convert("PAYPALISHIRING",3));
    }
}
