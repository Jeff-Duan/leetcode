package com.company.lcof;

public class LCOF05 {

    public String replaceSpace(String s) {
        if (s.length() == 0) {
            return "";
        }

        char[] source = s.toCharArray();
        char[] target = new char[s.length() * 3];

        int size = 0;
        for (int i = 0; i < source.length; i++) {
            if (' ' == source[i]) {
                target[size++] = '%';
                target[size++] = '2';
                target[size++] = '0';
            } else {
                target[size++] = source[i];
            }
        }
        return new String(target, 0, size);
    }

}
