package com.company.common;

import java.util.Stack;

public class P1047 {

    public String removeDuplicates(String S) {
        if (S.length() == 0) {
            return "";
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            if (stack.size() > 0 && stack.peek() == S.charAt(i)) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }

        StringBuffer r = new StringBuffer();

        while (stack.size() > 0) {
            r.append(stack.pop());
        }

        return String.valueOf(r.reverse());
    }

}
