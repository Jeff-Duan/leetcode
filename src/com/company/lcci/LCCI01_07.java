package com.company.lcci;

public class LCCI01_07 {

    public void swap(int[][] matrix, int i, int j, int p, int q) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[p][q];
        matrix[p][q] = tmp;
    }

    public void rotate(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                swap(matrix, i, j, matrix[i].length - 1 - i, j);
            }
        }
    }

}
