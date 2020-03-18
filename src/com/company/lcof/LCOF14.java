package com.company.lcof;

public class LCOF14 {

    public int cuttingRope(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }

        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int k = array[j] * array[i - j];
                if (k > array[i]) {
                    array[i] = k;
                }
            }
        }
        return array[n] % 1000000007;
    }

}
