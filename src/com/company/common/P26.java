package com.company.common;

public class P26 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                i = j;
                break;
            }
        }

        if (i == 0) {
            return nums.length;
        }

        int v = nums[i];

        int j = i;

        while (j < nums.length) {
            if (nums[j] > v) {
                v = nums[j];
                swap(nums, i++, j);
            }
            j++;
        }

        return i;
    }

}
