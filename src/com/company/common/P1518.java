package com.company.common;

public class P1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int r = numBottles;

        while (numBottles >= numExchange) {
            r += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }

        return r;
    }

}
