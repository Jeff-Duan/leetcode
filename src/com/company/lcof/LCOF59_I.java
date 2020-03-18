package com.company.lcof;

import java.util.Deque;
import java.util.LinkedList;

public class LCOF59_I {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{};
        }

        int[] r = new int[nums.length - k + 1];

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            while (queue.size() > 0 && nums[queue.getLast()] < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(i);
            while (queue.size() > 0 && i - queue.getFirst() == k) {
                queue.removeFirst();
            }

            if (i - k + 1 >= 0) {
                r[i - k + 1] = nums[queue.getFirst()];
            }
        }

        return r;
    }

}
