package com.company.lcof;

import java.util.Stack;

public class LCOF30 {

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
            if (stack2.size() == 0 || x <= stack2.peek()) {
                stack2.push(x);
            }
        }

        public void pop() {
            int i = stack1.pop();
            if (i == stack2.peek()) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

}
