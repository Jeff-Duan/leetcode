package com.company.lcci;

public class LCCI08_03 {

    public int findMagicIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int r = Integer.MAX_VALUE;
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int middle = (i + j) / 2 + 1;

            if (middle > 0 && nums[middle - 1] == nums[middle]) {

            }

            if (nums[middle] > middle) {
                j = middle - 1;
            } else if (nums[middle] < middle) {
                i = middle + 1;
            } else {
                j = middle - 1;
                r = Math.min(r, middle);
            }
        }

        return r;
    }

}
