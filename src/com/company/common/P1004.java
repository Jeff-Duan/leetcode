package com.company.common;

public class P1004 {

    public int longestOnes(int[] A, int K) {
        int result = 0;

        int count = 0;

        int i = 0;

        for (int j = 0; j < A.length; j++) {
            count += A[j];
            // 缩减窗口
            while (j - i + 1 - count > K) {
                count -= A[i++];
            }
            result = Math.max(result, j - i + 1);
        }

        return result;
    }

}
