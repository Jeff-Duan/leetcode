package com.company.lcci;

public class LCCI08_03 {

    public int findMagicIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int i = 0;

        while (i < nums.length) {
            if (i == nums[i]) {
                return i;
            }
            if (i < nums[i]) {
                i = nums[i];
            } else {
                i++;
            }
        }

        return -1;
    }

}
