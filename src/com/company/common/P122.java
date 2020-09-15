package com.company.common;

public class P122 {

    public int maxProfit(int[] prices) {
        int r = 0;

        if (prices.length > 2) {
            int v = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > v) {
                    r += prices[i] - v;
                }
                v = prices[i];
            }
        }

        return r;
    }

}
