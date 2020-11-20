package com.company.common;

public class P567 {

    public boolean match(int[] array1, int[] array2) {
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] != array1[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        char[] target = s1.toCharArray();
        char[] source = s2.toCharArray();

        int[] targetArray = new int[26];
        int[] sourceArray = new int[26];

        for (int i = 0; i < target.length; i++) {
            targetArray[target[i] - 'a']++;
        }

        for (int i = 0; i < source.length; i++) {
            sourceArray[source[i] - 'a']++;
            if (i >= target.length) {
                sourceArray[source[i - target.length] - 'a']--;
            }
            if (match(sourceArray, targetArray)) {
                return true;
            }
        }

        return false;
    }

}
