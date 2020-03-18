package com.company.lcci;

import java.util.Stack;

public class LCCI03_02 {

    class MinStack {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            if (stack2.size() == 0 || stack2.peek() >= x) {
                stack2.push(x);
            }
        }

        public void pop() {
            int i = stack1.pop();
            if (stack2.size() > 0 && stack2.peek() == i) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.size() > 0 ? stack1.peek() : -1;
        }

        public int getMin() {
            return stack2.size() > 0 ? stack2.peek() : -1;
        }
    }

}
