package com.company.lcof;

public class LCOF53_I {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = 0;

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int middle = (start + end) >>> 1;

            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        i = start;

        if (nums[start] != target) {
            return 0;
        }

        end = nums.length - 1;
        while (start < end) {
            int middle = (start + end) >>> 1;

            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                start = middle;
            }
        }
        j = end;

        return j - i + 1;
    }

}
