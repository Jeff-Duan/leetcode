package com.company.lcci;

public class LCCI01_05 {

    public int min(int i, int j, int k) {
        return Math.min(Math.min(i, j), k);
    }

    public boolean oneEditAway(String first, String second) {
        if (first.length() == 0) {
            return second.length() <= 1;
        }
        if (second.length() == 0) {
            return first.length() <= 1;
        }

        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int[][] dp = new int[first.length()][second.length()];

        for (int i = 0; i < dp.length; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i == 0 ? 1 : dp[i - 1][0] + 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (b[i] == a[0]) {
                dp[0][i] = i;
            } else {
                dp[0][i] = i == 0 ? 1 : dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (a[i] == b[j]) {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[first.length() - 1][second.length() - 1] < 2;
    }

}
