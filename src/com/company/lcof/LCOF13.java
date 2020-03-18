package com.company.lcof;

public class LCOF13 {

    boolean[][] flag;
    int k;
    int r;

    public int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }

    public void helper(int i, int j) {
        flag[i][j] = true;

        if (sum(i) + sum(j) > k) {
            return;
        }

        r++;
        if (i > 0 && !flag[i - 1][j]) {
            helper(i - 1, j);
        }
        if (i < flag.length - 1 && !flag[i + 1][j]) {
            helper(i + 1, j);
        }
        if (j > 0 && !flag[i][j - 1]) {
            helper(i, j - 1);
        }
        if (j < flag[i].length - 1 && !flag[i][j + 1]) {
            helper(i, j + 1);
        }
    }

    public int movingCount(int m, int n, int k) {
        flag = new boolean[m][n];
        this.k = k;

        helper(0, 0);

        return r;
    }

}
