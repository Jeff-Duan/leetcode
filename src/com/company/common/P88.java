package com.company.common;

public class P88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int point = n + m - 1;
        while (i >= 0 && j >= 0) {
            nums1[point++] = nums1[i] > nums2[j] ? nums1[i++] : nums2[j++];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }

}
