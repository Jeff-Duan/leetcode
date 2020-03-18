package com.company.common;

public class P300 {
    
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] tail = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int p = 0;
            int q = res;

            while (p < q) {
                int m = (p + q) / 2;
                if (nums[i] > tail[m]) {
                    p = m + 1;
                } else {
                    q = m;
                }
            }
            tail[p] = nums[i];
            if (p == res) {
                res++;
            }
        }
        return res;
    }

}
