package com.company.lcof;

import java.util.HashMap;

public class LCOF48 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int r = 1;
        char[] array = s.toCharArray();

        // DP
        /*boolean[][] dp = new boolean[array.length][array.length];
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < array.length; j++) {
                boolean x = i + 1 == j || dp[i + 1][j];
                boolean y = i == j - 1 || dp[i][j - 1];
                if (x && y && array[i] != array[j]) {
                    dp[i][j] = true;
                }

                if (dp[i][j] && j - i + 1 > r) {
                    r = j - i + 1;
                }
            }
        }*/

        // Sliding Window
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < array.length; j++) {
            if (!map.containsKey(array[j])) {
                map.put(array[j], 1);
            } else {
                map.put(array[j], map.get(array[j]) + 1);
            }
            while (map.get(array[j]) > 1) {
                map.put(array[i], map.get(array[i]) - 1);
                i++;
            }
            if (j - i + 1 > r) {
                r = j - i + 1;
            }
        }

        return r;
    }

}
