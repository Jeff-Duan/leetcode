package com.company.common;

import java.util.Arrays;
import java.util.Comparator;

public class P354 {

    // 最长上升子序列
    public int helper(int[] array) {
        int[] dp = new int[array.length];
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            int p = 0;
            int q = length;

            while (p < q) {
                int middle = (p + q) >>> 1;
                if (dp[middle] <= array[i]) {
                    p = middle + 1;
                } else {
                    q = middle;
                }
            }
            dp[p] = array[i];
            if (q == length) {
                length++;
            }
        }
        return length;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, Comparator.comparingInt(e -> e[0]));

        int i = 0;
        while (i < envelopes.length) {
            int k = i;
            while (k < envelopes.length && envelopes[i][0] == envelopes[k][0]) {
                k++;
            }
            if (k - 1 > i) {
                Arrays.sort(envelopes, i, k - 1, (e1, e2) -> e2[1] - e1[1]);
            }
            i = k;
        }

        int[] array = new int[envelopes.length];
        for (int j = 0; j < envelopes.length; j++) {
            array[j] = envelopes[j][1];
        }

        return helper(array);
    }

}
