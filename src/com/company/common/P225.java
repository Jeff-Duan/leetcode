package com.company.common;

import java.util.LinkedList;
import java.util.Queue;

public class P225 {

    class MyStack {

        Queue<Integer> queue1;
        Queue<Integer> queue2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            while (queue1.size() > 0) {
                queue2.add(queue1.poll());
            }
            queue1.add(x);
            while (queue2.size() > 0) {
                queue1.add(queue2.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue1.size() > 0 ? queue1.poll() : -1;
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue1.size() > 0 ? queue1.peek() : -1;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue1.size() == 0;
        }
    }

}
