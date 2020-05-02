package com.company.common;

public class P542 {

    boolean[][] flag;

    public int dfs(int[][] matrix, int i, int j, int k) {
        if (matrix[i][j] == 0) {
            return k;
        }

        int min = Integer.MAX_VALUE;

        flag[i][j] = true;
        if (i > 0 && !flag[i - 1][j]) {
            min = Math.min(min, dfs(matrix, i - 1, j, k + 1));
        }
        if (j < matrix[i].length - 1 && !flag[i][j + 1]) {
            min = Math.min(min, dfs(matrix, i, j + 1, k + 1));
        }
        if (i < matrix.length - 1 && !flag[i + 1][j]) {
            min = Math.min(min, dfs(matrix, i + 1, j, k + 1));
        }
        if (j > 0 && !flag[i][j - 1]) {
            min = Math.min(min, dfs(matrix, i, j - 1, k + 1));
        }
        flag[i][j] = false;

        return min;
    }

    public int[][] updateMatrix(int[][] matrix) {
        flag = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = dfs(matrix, i, j, 0);
                }
            }
        }

        return matrix;
    }

}
