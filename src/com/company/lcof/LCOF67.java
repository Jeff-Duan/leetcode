package com.company.lcof;

public class LCOF67 {

    public int strToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        int r = 0;
        char[] array = str.toCharArray();

        int start = 0;
        while (start < array.length && array[start] == ' ') {
            start++;
        }
        if (start >= array.length) {
            return r;
        }
        int end = array[start] == '-' || array[start] == '+' ? start + 1 : start;
        while (end < array.length && array[end] >= '0' && array[end] <= '9') {
            end++;
        }

        if (start < end && !(end - start == 1 && (array[start] == '-' || array[start] == '+'))) {
            StringBuilder tmp1 = new StringBuilder();
            for (int i = start; i < end; i++) {
                tmp1.append(array[i]);
            }
            String tmp2 = tmp1.toString();

            if (Double.parseDouble(tmp2) > Integer.MAX_VALUE) {
                r = Integer.MAX_VALUE;
            } else if (Double.parseDouble(tmp2) < Integer.MIN_VALUE) {
                r = Integer.MIN_VALUE;
            } else {
                r = Integer.parseInt(tmp2);
            }
        }

        return r;
    }

}
