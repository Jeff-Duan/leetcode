package com.company.lcof;

public class LCOF66 {

    public int[] constructArr(int[] a) {
        if (a.length == 0) {
            return new int[]{};
        }

        int[] prev = new int[a.length];
        prev[0] = 1;
        for (int i = 1; i < a.length; i++) {
            prev[i] = a[i - 1] * prev[i - 1];
        }

        int[] next = new int[a.length];
        next[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            next[i] = a[i + 1] * next[i + 1];
        }

        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            r[i] = prev[i] * next[i];
        }

        return r;
    }

}
