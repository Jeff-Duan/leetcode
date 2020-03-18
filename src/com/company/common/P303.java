package com.company.common;

public class P303 {

    class NumArray {

        int[] sumArray;

        public NumArray(int[] nums) {
            sumArray = new int[nums.length];

            int tmp = 0;
            for (int i = 0; i < nums.length; i++) {
                tmp = nums[i] + tmp;
                sumArray[i] = tmp;
            }
        }

        public int sumRange(int i, int j) {
            return i == 0 ? sumArray[j] : sumArray[j] - sumArray[i - 1];
        }
    }

}
