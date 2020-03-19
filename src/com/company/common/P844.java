package com.company.common;

import java.util.Stack;

public class P844 {

    public boolean backspaceCompare(String S, String T) {
        if (S.length() == 0) {
            return T.length() == 0;
        }
        if (T.length() == 0) {
            return false;
        }

        char[] p = S.toCharArray();
        char[] q = T.toCharArray();

        StringBuffer r1 = new StringBuffer();
        StringBuffer r2 = new StringBuffer();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < p.length; i++) {
            if (p[i] == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(p[i]);
            }
        }
        while (stack.size() > 0) {
            r1.append(stack.pop());
        }

        for (int i = 0; i < q.length; i++) {
            if (q[i] == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(q[i]);
            }
        }
        while (stack.size() > 0) {
            r2.append(stack.pop());
        }

        return String.valueOf(r1).equals(String.valueOf(r2));
    }

}
