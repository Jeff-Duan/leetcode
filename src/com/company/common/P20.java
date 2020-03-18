package com.company.common;

import java.util.Stack;

public class P20 {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }

        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case ')':
                    if (stack.size() == 0 || stack.peek() != '(') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.size() == 0 || stack.peek() != '{') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.size() == 0 || stack.peek() != '[') {
                        return false;
                    } else {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(array[i]);
                    break;
            }
        }

        return stack.isEmpty();
    }

}
