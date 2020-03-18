package com.company.lcci;

import java.util.Arrays;
import java.util.Comparator;

public class LCCI17_08 {

    // 求最长上升子序列长度
    public int helper(int[] array) {
        int[] dp = new int[array.length];
        int length = 0;
        for (int i = 0; i < dp.length; i++) {
            int p = 0;
            int q = length;

            while (p < q) {
                int middle = (p + q) / 2;
                if (dp[middle] < array[i]) {
                    p = middle + 1;
                } else {
                    q = middle;
                }
            }
            dp[p] = array[i];
            if (p == length) {
                length++;
            }
        }
        return length;
    }

    public int bestSeqAtIndex(int[] height, int[] weight) {
        if (height.length == 0 || weight.length == 0) {
            return 0;
        }

        int[][] dp = new int[height.length][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = height[i];
            dp[i][1] = weight[i];
        }

        Arrays.sort(dp, Comparator.comparingInt(e -> e[0]));

        int i = 0;
        while (i < dp.length) {
            int j = i;
            while (j < dp.length && dp[i][0] == dp[j][0]) {
                j++;
            }
            if (j - i > 1) {
                Arrays.sort(dp, i, j, (e1, e2) -> e2[1] - e1[1]);
            }
            i = j;
        }

        int[] r = new int[dp.length];
        for (int k = 0; k < dp.length; k++) {
            r[k] = dp[k][1];
        }
        return helper(r);
    }

}
