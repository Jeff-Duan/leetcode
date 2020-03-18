package com.company.common;

public class P5 {

    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        int length = 1;
        int index = 0;

        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                }
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    if (j - i + 1 > length) {
                        length = j - i + 1;
                        index = i;
                    }
                }
            }
        }

        return s.substring(index, index + length);
    }

}
