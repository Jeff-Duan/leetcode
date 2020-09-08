package com.company.common;

public class P66 {

    public int[] plusOne(int[] digits) {

        if (digits.length == 0) {
            return new int[]{};
        }

        int[] r;

        int bit = 0;

        digits[digits.length - 1] += 1;
        if (digits[digits.length - 1] > 9) {
            digits[digits.length - 1] %= 10;
            bit = 1;
        }

        if (digits.length > 1) {
            for (int i = digits.length - 2; i >= 0; i--) {
                int m = digits[i] + bit;
                if (m > 9) {
                    digits[i] = m % 10;
                } else {
                    digits[i] = m;
                    bit = 0;
                }
            }
        }

        if (bit == 1) {
            r = new int[digits.length + 1];
            r[0] = 1;
            System.arraycopy(digits, 0, r, 1, digits.length);
        } else {
            r = digits;
        }

        return r;
    }

}
