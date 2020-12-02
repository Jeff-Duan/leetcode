package com.company.lcci;

public class LCCI10_05 {

    // 比较字符串大小 返回值 0 等于 1 大于 -1 小于
    public int comparator(String word1, String word2) {
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        int i = 0;
        while (i < arr1.length && i < arr2.length) {
            if (arr1[i] > arr2[i]) {
                return 1;
            }
            if (arr1[i] < arr2[i]) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    // 查找非空字符串 返回值 >=0 对应下标 -1 无效下标
    public int findNotEmptyString(String[] words, int i, int j) {
        int m = i + (j - i) / 2;

        int index = m;
        while (index >= i && "".equals(words[index])) {
            index--;
        }
        if (index >= i) {
            return index;
        }

        index = m;
        while (index <= j && "".equals(words[index])) {
            index++;
        }
        if (index <= j) {
            return index;
        }

        return -1;
    }

    public int findString(String[] words, String s) {
        if (words.length == 0) {
            return -1;
        }

        int i = 0;
        int j = words.length - 1;
        while (i <= j) {
            int index = findNotEmptyString(words, i, j);

            if (index == -1) {
                return -1;
            }

            int r = comparator(words[index], s);
            if (r == 1) {
                j = index - 1;
            } else if (r == -1) {
                i = index + 1;
            } else {
                return index;
            }
        }

        return -1;
    }

}
