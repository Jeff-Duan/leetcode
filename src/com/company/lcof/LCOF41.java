package com.company.lcof;

import java.util.PriorityQueue;

public class LCOF41 {

    class MedianFinder {

        PriorityQueue<Integer> queue1;
        PriorityQueue<Integer> queue2;
        int count = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            queue1 = new PriorityQueue<>((e1, e2) -> e2 - e1);
            queue2 = new PriorityQueue<>();
        }

        public void addNum(int num) {
            count++;
            if ((count & 1) == 1) {
                queue2.add(num);
            } else {
                queue1.add(num);
            }
            if (queue1.size() > 0 && queue2.size() > 0 && queue2.peek() > queue1.peek()) {
                int tmp = queue1.poll();
                queue1.add(queue2.poll());
                queue2.add(tmp);
            }
        }

        public double findMedian() {
            double r = 0;
            if (count > 0) {
                r = (count & 1) == 1 ? queue2.peek() : (queue1.peek() + queue2.peek()) / 2.0;
            }
            return r;
        }
    }

}
