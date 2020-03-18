package com.company.lcci;

public class LCCI17_21 {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int[] prev = new int[height.length];
        int[] next = new int[height.length];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = i == 0 ? height[0] : Math.max(prev[i - 1], height[i]);
        }
        for (int i = next.length - 1; i >= 0; i--) {
            next[i] = i == next.length - 1 ? height[height.length - 1] : Math.max(next[i + 1], height[i]);
        }

        int r = 0;
        for (int i = 0; i < height.length; i++) {
            r += Math.min(prev[i], next[i]) - height[i];
        }

        return r;
    }

}
