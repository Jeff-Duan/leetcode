package com.company.common;

public class P63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[obstacleGrid.length - 1].length - 1] == 1) {
            return 0;
        }
        if (obstacleGrid.length == 1 || obstacleGrid[0].length == 1) {
            return 1;
        }

        int[] dp = new int[obstacleGrid[0].length];
        int index = dp.length;
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i < index ? 1 : 0;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] = j == 0 ? dp[0] : dp[j - 1] + dp[j];
                }
            }
        }

        return dp[dp.length - 1];
    }

}
