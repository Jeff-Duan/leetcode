package com.company.common;

public class P189 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }

        i = 0;
        j = k - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }

        i = k;
        j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

}
