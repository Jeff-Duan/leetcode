package com.company.common;

public class P441 {

    public int arrangeCoins(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int i = 2;
        int j = n;
        int r = 0;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if ((long) m * m + m > (long) n * 2) {
                j = m - 1;
            } else if ((long) m * m + m < (long) n * 2) {
                r = Math.max(r, m);
                i = m + 1;
            } else {
                return m;
            }
        }

        return r;
    }

}
