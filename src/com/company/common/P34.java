package com.company.common;

public class P34 {

    public int search(int[] nums, int start, int end, int target, boolean left) {
        int i = start;
        int j = end;
        if (left) {
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (nums[m] >= target) {
                    j = m - 1;
                } else {
                    i = m + 1;
                }
            }
            return i;
        } else {
            while (i <= j) {
                int m = i + (j - i) / 2;
                if (nums[m] <= target) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            }
            return j;
        }
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        int leftIndex = search(nums, 0, nums.length - 1, target, true);

        if (leftIndex < 0 || leftIndex > nums.length - 1 || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }

        int rightIndex = search(nums, leftIndex, nums.length - 1, target, false);

        return new int[]{leftIndex, rightIndex};
    }

}
