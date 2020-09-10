package com.company.common;

public class P169 {

    public int majorityElement(int[] nums) {
        int point = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                point = i;
                count++;
            } else {
                if (nums[i] == nums[point]) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return nums[point];
    }

}
