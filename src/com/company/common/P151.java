package com.company.common;

public class P151 {

    public void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void reverseString(char[] array) {
        int middle = array.length >> 1;
        for (int i = 0; i < middle; i++) {
            swap(array, i, array.length - 1 - i);
        }
    }

    public void reverseString(char[] array, int i, int j) {
        int length = j - i + 1;
        int middle = (length >> 1) + i;
        for (int k = i; k < middle; k++) {
            swap(array, k, i + j - k);
        }
    }

    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] array = s.toCharArray();

        reverseString(array);

        int start = 0;
        while (start < array.length) {
            int i = start;
            while (i < array.length && array[i] == ' ') {
                i++;
            }
            int j = 0;
            while (i < array.length && array[i] != ' ') {
                i++;
                j++;
            }
            if (i <= array.length) {
                reverseString(array, start, i - 1);
            }
            start += j + 1;
        }

        return new String(array).trim();
    }

}
