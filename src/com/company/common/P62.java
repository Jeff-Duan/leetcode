package com.company.common;

import java.util.Arrays;

public class P62 {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[] dp = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < dp.length; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }

        return dp[dp.length - 1];
    }

}
