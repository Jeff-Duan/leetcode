package com.company.lcof;

public class LCOF53_II {

    public int missingNumber(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int middle = (start + end) >>> 1;

            if (middle == nums[middle]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        return start == nums[start] ? nums.length : start;
    }

}
