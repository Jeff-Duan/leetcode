package com.company.common;

public class P1351 {

    public int countNegatives(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            int[] arr = grid[i];

            int left = 0;
            int right = arr.length - 1;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (arr[middle] < 0) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }

            if (arr[left] < 0) {
                result += arr.length - left;
            }
        }

        return result;
    }

}
