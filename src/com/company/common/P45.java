package com.company.common;

public class P45 {

    public int jump(int[] nums) {
        int r = 0;
        int f = 0;
        while (f < nums.length - 1) {
            r++;
            int end = nums[f] + f;
            if (end >= nums.length - 1) {
                break;
            } else {
                int max = 0;
                int j = f;
                for (int i = 1; i <= nums[f]; i++) {
                    if (i + nums[f + i] >= max) {
                        max = i + nums[f + i];
                        j = f + i;
                    }
                }
                f = j;
            }
        }
        return r;
    }

}
