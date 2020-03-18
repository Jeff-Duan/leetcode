package com.company.lcof;

public class LCOF64 {

    public int sumNums(int n) {
        return n > 0 ? n + sumNums(n - 1) : n;
    }

}
