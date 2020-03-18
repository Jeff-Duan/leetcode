package com.company.common;

public class P215 {

    public void buildHeap(int[] n, int k) {
        for (int i = k / 2 - 1; i >= 0; i--) {
            heapify(n, k, i);
        }
    }

    public void heapify(int[] n, int k, int i) {
        int min = i;
        while (true) {
            if (i * 2 + 1 < k && n[i * 2 + 1] < n[i]) {
                min = i * 2 + 1;
            }
            if (i * 2 + 2 < k && n[i * 2 + 2] < n[min]) {
                min = i * 2 + 2;
            }
            if (min == i) {
                break;
            }
            swap(n, i, min);
            i = min;
        }
    }

    public void swap(int[] n, int i, int j) {
        int tmp = n[i];
        n[i] = n[j];
        n[j] = tmp;
    }


    public int findKthLargest(int[] nums, int k) {
        buildHeap(nums, k);
        for (int i = k; i < nums.length; i++) {
            if (nums[i] >= nums[0]) {
                nums[0] = nums[i];
                heapify(nums, k, 0);
            }
        }
        return nums[0];
    }
}
