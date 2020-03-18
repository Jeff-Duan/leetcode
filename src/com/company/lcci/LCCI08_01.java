package com.company.lcci;

public class LCCI08_01 {

    public int waysToStep(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }

        int x = 1;
        int y = 2;
        int z = 4;
        for (int i = 4; i <= n; i++) {
            int r = ((x % 1000000007 + y % 1000000007) % 1000000007 + z % 1000000007) % 1000000007;
            x = y;
            y = z;
            z = r;
        }
        return z;
    }

}
