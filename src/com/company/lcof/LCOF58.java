package com.company.lcof;

public class LCOF58 {

    public void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public void reverse(char[] array, int i, int j) {
        int length = j - i + 1;
        int pivot = (i + j) / 2;
        while (i < pivot) {
            swap(array, i, j - i);
            i++;
        }
        if ((length & 1) == 0) {
            swap(array, pivot, pivot + 1);
        }
    }

    public String reverseWords(String s) {
        if (s.length() == 0) {
            return s;
        }

        char[] array = s.toCharArray();

        reverse(array, 0, array.length - 1);

        int start = 0;
        while (start <= array.length - 1) {
            int index = start;
            int count1 = 0;
            int count2 = 0;
            while (index < array.length && array[index] == ' ') {
                index++;
                count1++;
            }
            while (index < array.length && array[index] != ' ') {
                index++;
                count2++;
            }
            if (count2 == 0) {
                break;
            }
            reverse(array, start, start + count1 + count2 - 1);

            start += count2 + 1;
        }

        return start == 0 ? "" : new String(array, 0, start - 1);
    }

    public String reverseLeftWords(String s, int n) {
        char[] array = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < array.length - 1) {
                swap(array, j, j + 1);
                j++;
            }
        }
        return new String(array);
    }

}
