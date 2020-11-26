package com.company.common;

public class P374 {

    public int guess(int num) {
        return 0;
    }

    public int guessNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int i = 0;
        int j = n;
        while (i <= j) {
            int m = i + (j - i) / 2;
            int v = guess(m);
            if (v == 1) {
                i = m + 1;
            } else if (v == -1) {
                j = m - 1;
            } else {
                return m;
            }
        }

        return i;
    }

}
