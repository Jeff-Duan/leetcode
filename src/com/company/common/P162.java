package com.company.common;

public class P162 {

    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (m == 0 && nums[m] > nums[m + 1]) {
                return m;
            }
            if (m == nums.length - 1 && nums[m] > nums[m - 1]) {
                return m;
            }
            if (m > 0 && m < nums.length - 1 && nums[m] > nums[m - 1] && nums[m] > nums[m + 1]) {
                return m;
            }
            if (nums[m] < nums[m + 1]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }

        return -1;
    }

}
