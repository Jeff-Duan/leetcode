package com.company.common;

public class P70 {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;
        int r = 0;
        for (int i = 3; i < n; i++) {
            r = first + second;

            first = second;
            second = r;
        }
        return r;
    }

}
