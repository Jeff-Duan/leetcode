package com.company.common;

public class P221 {

    public int min(int i, int j, int k) {
        int min = Math.min(i, j);
        return Math.min(min, k);
    }

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }

        int r = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = Integer.parseInt(String.valueOf(matrix[i][0]));
            r = dp[i][0] == 1 ? 1 : r;
        }
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = Integer.parseInt(String.valueOf(matrix[0][i]));
            r = dp[0][i] == 1 ? 1 : r;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    int min = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]);
                    dp[i][j] = min + 1;
                    r = Math.max(min + 1, r);
                }
            }
        }
        return r * r;
    }

}
