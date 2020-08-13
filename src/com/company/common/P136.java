package com.company.common;

public class P136 {

    public int singleNumber(int[] nums) {
        int r = 0;
        for (int i : nums) {
            r ^= i;
        }
        return r;
    }

}
