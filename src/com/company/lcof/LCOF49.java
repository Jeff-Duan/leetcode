package com.company.lcof;

public class LCOF49 {

    public int min(int i, int j, int k) {
        int min = Math.min(i, j);
        return Math.min(min, k);
    }

    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] r = new int[n];
        r[0] = 1;

        int index = 1;
        while (index < r.length) {
            int m2 = 0;
            int m3 = 0;
            int m5 = 0;
            while (r[m2] * 2 <= r[index - 1]) {
                m2++;
            }
            while (r[m3] * 3 <= r[index - 1]) {
                m3++;
            }
            while (r[m5] * 5 <= r[index - 1]) {
                m5++;
            }
            r[index] = min(r[m2] * 2, r[m3] * 3, r[m5] * 5);
            System.out.println(r[index]);
            index++;
        }

        return r[r.length - 1];
    }

}
