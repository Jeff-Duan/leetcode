package com.company.lcof;

public class LCOF65 {

    public int add(int a, int b) {
        int num1, num2;
        do {
            num1 = a ^ b;
            num2 = (a & b) << 1;

            a = num1;
            b = num2;
        } while (num2 != 0);
        return num1;
    }

}
