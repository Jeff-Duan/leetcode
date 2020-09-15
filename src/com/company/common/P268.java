package com.company.common;

public class P268 {

    public int missingNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            r ^= i ^ nums[i];
        }
        return r ^ nums.length;
    }

}
