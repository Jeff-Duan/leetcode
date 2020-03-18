package com.company.common;

public class P1025 {

    public boolean divisorGame(int N) {
        if (N < 2) {
            return false;
        }

        boolean[] dp = new boolean[N + 1];
        dp[2] = true;

        for (int i = 3; i <= N; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (!dp[j] && i % (i - j) == 0) {
                    dp[i] = true;
                }
            }
        }

        return dp[dp.length - 1];
    }

}
