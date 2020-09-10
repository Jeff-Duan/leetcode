package com.company.common;

public class P167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int val = numbers[i] + numbers[j];
            if (val == target) {
                break;
            } else if (val > target) {
                j--;
            } else if (val < target) {
                i++;
            }
        }
        return new int[]{i, j};
    }

}
