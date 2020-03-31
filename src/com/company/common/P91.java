package com.company.common;

public class P91 {

    public int numDecodings(String s) {
        char[] array = s.toCharArray();

        if (array.length == 0 || array[0] == '0') {
            return 0;
        }

        int p = 1;
        int q = 1;
        for (int i = 1; i < array.length; i++) {
            int v = 0;
            if (array[i] != '0') {
                v += q;
            }

            int l = Integer.parseInt(String.valueOf(array[i - 1])) * 10 + Integer.parseInt(String.valueOf(array[i]));
            if (l >= 10 && l <= 26) {
                v += p;
            }

            if (v == 0) {
                return 0;
            }
            p = q;
            q = v;
        }

        return q;
    }

}
