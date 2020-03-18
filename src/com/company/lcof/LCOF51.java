package com.company.lcof;

public class LCOF51 {

    int count = 0;

    public void merge(int[] nums, int start1, int end1, int start2, int end2) {
        int[] array = new int[end2 - start1 + 1];
        int index = array.length - 1;

        while (start1 <= end1 && start2 <= end2) {
            if (nums[end1] > nums[end2]) {
                array[index--] = nums[end1--];
                count += end2 - start2 + 1;
            } else {
                array[index--] = nums[end2--];
            }
        }
        while (start1 <= end1) {
            array[index--] = nums[end1--];
        }
        while (start2 <= end2) {
            array[index--] = nums[end2--];
        }

        for (int i = 0; i < array.length; i++) {
            nums[start1 + i] = array[i];
        }
    }

    public void helper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) >>> 1;
        helper(nums, start, middle);
        helper(nums, middle + 1, end);
        merge(nums, start, middle, middle + 1, end);
    }

    public int reversePairs(int[] nums) {
        helper(nums, 0, nums.length - 1);
        return count;
    }

}
