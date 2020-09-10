package com.company.common;

public class P905 {

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while (i < j) {
            while (i < j && (A[i] & 1) == 0) {
                i++;
            }
            while (i < j && (A[j] & 1) == 1) {
                j--;
            }
            swap(A, i, j);
        }
        return A;
    }

}
