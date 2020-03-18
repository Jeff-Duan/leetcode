package com.company.lcof;

public class LCOF04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int i = matrix.length - 1;
        int j = 0;

        while (true) {
            if (i < 0 || j > matrix[0].length - 1) {
                break;
            }

            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                i--;
                continue;
            }

            if (matrix[i][j] < target) {
                j++;
                continue;
            }

            if (i == 0 && j == matrix[0].length - 1) {
                break;
            }
        }
        return false;
    }

}
