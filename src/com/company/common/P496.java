package com.company.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for (int value : nums2) {
            stack1.push(value);
        }

        Map<Integer, Integer> map = new HashMap<>();

        while (stack1.size() > 0) {
            int v = stack1.pop();

            while (stack2.size() > 0) {
                int t = stack2.pop();

                if (t > v) {
                    map.put(v, t);
                    stack2.push(t);
                    stack2.push(v);
                    break;
                }
            }

            if (!map.containsKey(v)) {
                map.put(v, -1);
                stack2.push(v);
            }
        }

        int[] r = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            r[i] = map.get(nums1[i]);
        }

        return r;
    }

}
