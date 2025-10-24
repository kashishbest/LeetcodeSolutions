package org.example.no_hundred;

import java.util.Stack;

public class ValidParantheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{': stack.push(ch);
                break;
                case ')':
                    if(stack.isEmpty()) return false;
                    char temp = stack.pop();
                    if(temp != '(')
                    return false;
                    break;
                case ']':
                    if(stack.isEmpty()) return false;
                    temp = stack.pop();
                    if(temp != '[')
                        return false;
                    break;
                case '}':
                    if(stack.isEmpty()) return false;
                    temp = stack.pop();
                    if(temp != '{')
                        return false;
                    break;

            }
        }
        return stack.isEmpty();
    }
}
