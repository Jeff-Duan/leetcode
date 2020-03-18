package com.company.lcof;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class LCOF59_II {

    class MaxQueue {

        Queue<Integer> data;
        Deque<Integer> max;

        public MaxQueue() {
            data = new LinkedList<>();
            max = new LinkedList<>();
        }

        public int max_value() {
            return max.size() > 0 ? max.getFirst() : -1;
        }

        public void push_back(int value) {
            while (max.size() > 0 && max.getLast() < value) {
                max.removeLast();
            }
            data.add(value);
            max.addLast(value);
        }

        public int pop_front() {
            int r = -1;
            if (data.size() > 0) {
                r = data.poll();
                if (max.getFirst() == r) {
                    max.removeFirst();
                }
            }
            return r;
        }
    }

}
