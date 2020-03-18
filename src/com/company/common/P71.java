package com.company.common;

import java.util.Stack;

public class P71 {

    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "/";
        }

        Stack<String> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();

        StringBuffer r = new StringBuffer();

        char[] array = path.toCharArray();
        int i = 0;
        while (i < array.length) {
            int j = i + 1;

            while (j < array.length && array[j] != '/') {
                j++;
            }

            if (j - i > 1) {
                String node = new String(array, i + 1, j - i - 1);
                if (("..").equals(node)) {
                    if (stack1.size() > 0) {
                        stack1.pop();
                    }
                } else {
                    if (!(".").equals(node)) {
                        stack1.push(node);
                    }
                }
            }

            i = j;
        }

        while (stack1.size() > 0) {
            stack2.push(stack1.pop());
        }
        while (stack2.size() > 0) {
            r.append("/").append(stack2.pop());
        }

        return r.length() == 0 ? "/" : String.valueOf(r);
    }

}
