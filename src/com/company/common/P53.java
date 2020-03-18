package com.company.common;

public class P53 {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        new P53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

}
