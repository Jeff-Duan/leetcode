package com.company.lcci;

public class LCCI01_06 {

    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }

        StringBuffer r = new StringBuffer();
        char[] array = S.toCharArray();

        int i = 0;
        while (i < array.length) {
            int j = i;

            while (j < array.length && array[i] == array[j]) {
                j++;
            }
            r.append(array[i]);
            r.append(j - i);

            i = j;
        }

        return r.length() < S.length() ? String.valueOf(r) : S;
    }

}
