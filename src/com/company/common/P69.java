package com.company.common;

public class P69 {

    public int mySqrt(int x) {
        long i = 0;
        long j = x / 2 + 1;
        while (i < j) {
            long middle = (i + j + 1) >>> 1;
            if (middle * middle <= x) {
                i = middle;
            } else {
                j = middle + 1;
            }
        }

        return (int) i;
    }

}
