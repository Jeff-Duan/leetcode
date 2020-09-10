package com.company.common;

public class P283 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void moveZeroes(int[] nums) {
        int first = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                first = i;
                break;
            }
        }

        if (first < 0) {
            return;
        }

        for (int i = first + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, first++, i);
            }
        }
    }

}
