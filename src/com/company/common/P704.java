package com.company.common;

public class P704 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] > target) {
                j = m - 1;
            } else if (nums[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

}
