package com.company.lcof;

import java.util.Stack;

public class LCOF09 {

    class CQueue {
        Stack stack1;
        Stack stack2;

        public CQueue() {
            stack1 = new Stack();
            stack2 = new Stack();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.isEmpty()) {
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.isEmpty() ? -1 : (int) stack2.pop();
        }
    }

}
