package com.company.common;

public class P744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0;
        int j = letters.length;
        while (i < j) {
            int m = i + (j - i) / 2;
            if (letters[m] <= target) {
                i = m + 1;
            } else {
                j = m;
            }
        }
        return j == letters.length ? letters[0] : letters[j];
    }

}
