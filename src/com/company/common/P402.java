package com.company.common;

import java.util.Stack;

public class P402 {

    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() <= k) {
            return "0";
        }

        StringBuilder r = new StringBuilder();
        char[] array = num.toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.push(array[0]);

        for (int i = 1; i < array.length; i++) {
            while (k > 0 && stack.size() > 0 && stack.peek() > array[i]) {
                stack.pop();
                k--;
            }
            stack.push(array[i]);
        }

        while (stack.size() > 0) {
            if (k > 0) {
                stack.pop();
                k--;
            } else {
                r.append(stack.pop());
            }
        }

        r.reverse();

        int index = 0;
        while (index < r.length() - 1 && r.charAt(index) == '0') {
            index++;
        }

        return r.substring(index);
    }

}
