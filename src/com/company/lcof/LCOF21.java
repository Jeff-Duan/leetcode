package com.company.lcof;

public class LCOF21 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] exchange(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int flag = start;

        for (int i = start; i <= end; i++) {
            if ((nums[i] & 1) == 1) {
                swap(nums, i, flag);
                flag++;
            }
        }

        return nums;
    }

}
