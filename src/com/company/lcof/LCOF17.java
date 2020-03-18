package com.company.lcof;

public class LCOF17 {

    public int[] printNumbers(int n) {
        int length = 0;
        while (n >= 0) {
            length += (int) (9 * Math.pow(10, n - 1));
            n--;
        }

        int[] r = new int[length];
        for (int i = 0; i < r.length; i++) {
            r[i] = i + 1;
        }
        return r;
    }

}
