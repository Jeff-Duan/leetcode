package com.company.common;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295 {

    class MedianFinder {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Comparator<Integer>) (e1, e2) -> e2 - e1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {

        }

        public void addNum(int num) {
            count++;
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                int i = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(i);
            }
        }

        public double findMedian() {
            if (maxHeap.size() == 0 && minHeap.size() == 0)
                return 0;
            return maxHeap.size() == minHeap.size() ? (maxHeap.peek() + minHeap.peek()) / 2.0 : maxHeap.peek();
        }
    }

}
