package com.company.common;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }

        int[] longArray = null;
        int[] shortArray = null;
        if (nums1.length >= nums2.length) {
            longArray = nums1;
            shortArray = nums2;
        } else {
            longArray = nums2;
            shortArray = nums1;
        }
        Arrays.sort(longArray);

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < shortArray.length; i++) {
            if (!set.contains(shortArray[i])) {
                int left = 0;
                int right = longArray.length - 1;
                while (left <= right) {
                    int middle = left + (right - left) / 2;
                    if (longArray[middle] > shortArray[i]) {
                        right = middle - 1;
                    } else if (longArray[middle] < shortArray[i]) {
                        left = middle + 1;
                    } else {
                        set.add(shortArray[i]);
                        break;
                    }
                }
            }
        }

        int[] result = new int[set.size()];
        int offset = 0;
        for (Integer integer : set) {
            result[offset++] = integer;
        }

        return result;
    }

}
