package com.company.common;

public class P912 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int[] nums, int start, int end) {
        int flag = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= nums[end]) {
                swap(nums, flag, i);
                flag++;
            }
        }
        swap(nums, flag, end);
        return flag;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int k = partition(nums, start, end);
        quickSort(nums, start, k - 1);
        quickSort(nums, k + 1, end);
    }

    public int[] sortArray(int[] nums) {
        if (nums.length > 1) {
            quickSort(nums, 0, nums.length - 1);
        }
        return nums;
    }

}
