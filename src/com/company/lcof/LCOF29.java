package com.company.lcof;

public class LCOF29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }

        int[] r = new int[(matrix.length) * (matrix[0].length)];

        int index = 0;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                r[index++] = matrix[top][i];
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                r[index++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left && top <= bottom; i--) {
                r[index++] = matrix[bottom][i];
            }
            bottom--;
            for (int i = bottom; i >= top && left <= right; i--) {
                r[index++] = matrix[i][left];
            }
            left++;
        }

        return r;
    }

}
