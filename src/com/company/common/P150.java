package com.company.common;

import java.util.Stack;

public class P150 {

    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (("+").equals(tokens[i])) {
                stack.push(stack.pop() + stack.pop());
            } else if (("-").equals(tokens[i])) {
                int k = stack.pop();
                stack.push(stack.pop() - k);
            } else if (("*").equals(tokens[i])) {
                stack.push(stack.pop() * stack.pop());
            } else if (("/").equals(tokens[i])) {
                int k = stack.pop();
                stack.push(stack.pop() / k);
            } else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }

        return stack.size() > 0 ? stack.peek() : 0;

    }

}
