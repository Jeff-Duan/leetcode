package com.company.lcof;

public class LCOF15 {

    public int hammingWeight(int n) {
        int r = 0;
        while (n != 0) {
            r++;
            n &= (n - 1);
        }
        return r;
    }

}
