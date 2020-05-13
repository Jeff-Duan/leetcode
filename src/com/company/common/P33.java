package com.company.common;

public class P33 {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (target < nums[0] && target > nums[nums.length - 1]) {
            return -1;
        }

        if (target == nums[0]) {
            return 0;
        }
        if (target == nums[nums.length - 1]) {
            return nums.length - 1;
        }

        int i = 0;
        int j = nums.length - 1;

        if (nums[0] > nums[nums.length - 1]) {
            while (i <= j) {
                int middle = (i + j) >> 1;
                if (nums[middle] == target) {
                    return middle;
                }

                if (target > nums[0]) {
                    if (nums[middle] > target || nums[middle] <= nums[nums.length - 1]) {
                        j = middle - 1;
                    } else {
                        i = middle + 1;
                    }
                } else {
                    if (nums[middle] < target || nums[middle] >= nums[0]) {
                        i = middle + 1;
                    } else {
                        j = middle - 1;
                    }
                }
            }
        } else {
            while (i <= j) {
                int middle = (i + j) >> 1;
                if (nums[middle] == target) {
                    return middle;
                }

                if (nums[middle] > target) {
                    j = middle - 1;
                } else {
                    i = middle + 1;
                }
            }
        }

        return -1;
    }

}
