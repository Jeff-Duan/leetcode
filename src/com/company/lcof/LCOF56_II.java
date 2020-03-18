package com.company.lcof;

public class LCOF56_II {

    public int singleNumber(int[] nums) {
        if (nums.length <= 3) {
            return 0;
        }

        int r = 0;

        int[] array = new int[Integer.SIZE];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < Integer.SIZE; j++) {
                if ((nums[i] >>> j & 1) == 1) {
                    array[j] += 1;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 3 == 1) {
                r += Math.pow(2, i);
            }
        }

        return r;
    }

}
