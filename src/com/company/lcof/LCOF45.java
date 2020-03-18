package com.company.lcof;

public class LCOF45 {

    public boolean compare(String i, String j) {
        return Double.parseDouble(i + j) < Double.parseDouble(j + i);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int partition(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i < end; i++) {
            if (compare(String.valueOf(nums[i]), String.valueOf(nums[end]))) {
                swap(nums, index, i);
                index = i;
            }
        }
        swap(nums, index, end);
        return index;
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int flag = partition(nums, start, end);
        quickSort(nums, start, flag - 1);
        quickSort(nums, flag + 1, end);
    }

    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            r.append(nums[i]);
        }
        return r.toString();
    }

}
