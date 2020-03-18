package com.company.lcof;

public class LCOF16 {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double r = 1;
        long t = n;
        if (t < 0) {
            x = 1 / x;
            t *= -1;
        }

        while (t > 0) {
            if ((t & 1) == 1) {
                r *= x;
            }
            x *= x;

            t >>>= 1;
        }
        return n > 0 ? r : 1 / r;
    }

}
