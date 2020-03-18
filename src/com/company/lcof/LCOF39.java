package com.company.lcof;

public class LCOF39 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int[] nums, int start, int end) {
        int flag = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < nums[end]) {
                swap(nums, flag, i);
                flag++;
            }
        }
        swap(nums, flag, end);
        return flag;
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int r = 0;

        int start = 0;
        int end = nums.length - 1;

        while (true) {
            int i = partition(nums, start, end);
            if (i > nums.length / 2) {
                end = i - 1;
            } else if (i < nums.length / 2) {
                start = i + 1;
            } else {
                r = i;
                break;
            }
        }
        return nums[r];
    }

}
