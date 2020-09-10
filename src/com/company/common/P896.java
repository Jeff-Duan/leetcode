package com.company.common;

public class P896 {

    public boolean isMonotonic(int[] A) {
        if (A.length > 2) {
            boolean flag = false;
            for (int i = 1; i < A.length; i++) {
                if (A[i] > A[0]) {
                    flag = true;
                    break;
                }
                if (A[i] < A[0]) {
                    flag = false;
                    break;
                }
            }

            for (int i = 1; i < A.length; i++) {
                if (flag && A[i - 1] > A[i]) {
                    return false;
                }
                if (!flag && A[i - 1] < A[i]) {
                    return false;
                }
            }
        }
        return true;
    }

}
