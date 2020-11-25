package com.company.common;

public class P278 {

    public boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        if (n == 0) {
            return -1;
        }

        int i = 1;
        int j = n;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (isBadVersion(m)) {
                j = m;
            } else {
                i = m + 1;
            }
        }

        return isBadVersion(i) ? i : -1;
    }

}
