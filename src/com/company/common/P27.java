package com.company.common;

public class P27 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int removeElement(int[] nums, int val) {
        int i = nums.length;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                i = j;
                break;
            }
        }

        if (i == nums.length) {
            return nums.length;
        }

        if (i == nums.length - 1) {
            return nums.length - 1;
        }

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] != val) {
                swap(nums, i++, j);
            }
        }
        return i;
    }

}
