package com.company.common;

public class P198 {

    public int rob(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(nums[i] + first, second);
            first = tmp;
        }
        return second;
    }

}
