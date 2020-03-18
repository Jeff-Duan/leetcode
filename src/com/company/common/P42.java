package com.company.common;

public class P42 {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int[] before = new int[height.length];
        int[] after = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
            before[i] = max;
        }
        max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > max) {
                max = height[i];
            }
            after[i] = max;
        }

        int r = 0;
        for (int i = 0; i < height.length; i++) {
            r += Math.min(before[i], after[i]) - height[i];
        }

        return r;
    }

}
