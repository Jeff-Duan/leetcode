package com.company.lcof;

public class LCOF57_I {

    public int[] twoSum(int[] nums, int target) {
        int[] r = new int[2];

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (start + end) >>> 1;
            if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        start = 0;
        while (start < end) {
            if (nums[start] + nums[end] > target) {
                end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                r[0] = nums[start];
                r[1] = nums[end];
                break;
            }
        }

        return r;
    }

}
