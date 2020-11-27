package com.company.common;

public class P852 {

    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length == 0) {
            return -1;
        }

        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (arr[m] > arr[m + 1] && arr[m] > arr[m - 1]) {
                return m;
            } else if (arr[m] > arr[m + 1]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }

        return -1;
    }

}
