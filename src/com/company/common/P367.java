package com.company.common;

public class P367 {

    public boolean isPerfectSquare(int num) {
        if (num <= 1) {
            return true;
        }

        long i = 0;
        long j = num / 2;
        while (i <= j) {
            long m = i + (j - i) / 2;
            long n = m * m;
            if (n == num) {
                return true;
            }
            if (n > num) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return false;
    }

}
