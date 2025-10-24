package org.example.no_hundred;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recurse(new StringBuilder(),0,0,n,result);
        return result;
    }

    void recurse(StringBuilder current, int open, int close, int n, List<String> result) {
        if(open == n && close == n) {
            result.add(current.toString());
            return;
        }

        if(open < n) {
            current.append('(');
            recurse(current, open+1,close,n,result);
            current.deleteCharAt(current.length()-1);
        }

        if(open > close) {
            current.append(')');
            recurse(current, open,close+1,n,result);
            current.deleteCharAt(current.length()-1);
        }
    }
}
