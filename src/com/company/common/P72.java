package com.company.common;

public class P72 {

    char[] a;
    char[] b;

    int min = Integer.MAX_VALUE;

    // 回溯
    public void helper(int i, int j, int v) {
        if (i == a.length || j == b.length) {
            if (i <= a.length) {
                v += a.length - i;
            }
            if (j <= b.length) {
                v += b.length - j;
            }
            if (v < min) {
                min = v;
            }
            return;
        }
        if (a[i] == b[j]) {
            helper(i + 1, j + 1, v);
        } else {
            helper(i + 1, j, v + 1);
            helper(i, j + 1, v + 1);
            helper(i + 1, j + 1, v + 1);
        }
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        a = word1.toCharArray();
        b = word2.toCharArray();

        int[][] dp = new int[a.length][b.length];
        for (int i = 0; i < dp.length; i++) {
            if (a[i] == b[0]) {
                dp[i][0] = i;
            } else {
                dp[i][0] = i == 0 ? 1 : dp[i - 1][0] + 1;
            }
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (a[0] == b[i]) {
                dp[0][i] = i;
            } else {
                dp[0][i] = i == 0 ? 1 : dp[0][i - 1] + 1;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int v = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (a[i] == b[j]) {
                    v = Math.min(v, dp[i - 1][j - 1]);
                } else {
                    v = Math.min(v, dp[i - 1][j - 1] + 1);
                }
                dp[i][j] = v;
            }
        }

        return dp[a.length - 1][b.length - 1];
    }

}
