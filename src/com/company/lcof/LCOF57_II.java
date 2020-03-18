package com.company.lcof;

public class LCOF57_II {

    public int[][] findContinuousSequence(int target) {
        int length = (target + 1) >>> 1;

        int count = 0;

        int[] array = new int[length];
        int index = 0;
        for (int i = length; i > 0; i--) {
            int sum = 0;
            int j = i;
            while (sum < target) {
                sum += j;
                if (sum == target) {
                    array[index++] = j;
                    array[index++] = i;
                    count++;
                }
                j--;
            }
        }

        int[][] r = new int[count][];
        int t = 0;
        while (array[t] > 0) {
            int[] tmp = new int[array[t + 1] - array[t] + 1];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = i + array[t];
            }
            r[--count] = tmp;

            t += 2;
        }

        return r;
    }

}
