package com.company.common;

import java.util.Stack;

public class P682 {

    public int calPoints(String[] ops) {
        if (ops.length == 0) {
            return 0;
        }

        int r = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (("+").equals(ops[i])) {
                int p = stack.pop();
                int q = stack.peek();
                stack.push(p);
                stack.push(p + q);
            } else if (("D").equals(ops[i])) {
                stack.push(stack.peek() * 2);
            } else if (("C").equals(ops[i])) {
                stack.pop();
            } else {
                stack.push(Integer.valueOf(ops[i]));
            }
        }

        while (stack.size() > 0) {
            r += stack.pop();
        }

        return r;
    }

}
