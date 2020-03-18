package com.company.common;

public class P121 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int min = prices[0];
        int max = prices[0];
        int r = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
            if (prices[i] > max) {
                max = prices[i];
            }

            if (max - min > r) {
                r = max - min;
            }
        }

        return r;
    }

}
