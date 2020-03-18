package com.company.lcof;

public class LCOF56_I {

    public int[] singleNumbers(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }

        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r ^= nums[i];
        }

        int k = 0;
        while ((r & 1) == 0 && k < Integer.SIZE) {
            r = r >>> 1;
            k++;
        }

        int x = 0;
        int y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] >>> k & 1) == 1) {
                x ^= nums[i];
            } else {
                y ^= nums[i];
            }
        }

        return new int[]{x, y};
    }

}
