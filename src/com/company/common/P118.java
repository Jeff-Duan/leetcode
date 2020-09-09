package com.company.common;

import java.util.ArrayList;
import java.util.List;

public class P118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> r = new ArrayList<>();

        if (numRows == 0) {
            return r;
        }

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        r.add(row1);

        if (numRows == 1) {
            return r;
        }

        List<Integer> row2 = new ArrayList<>();
        row2.add(1);
        row2.add(1);
        r.add(row2);

        if (numRows == 2) {
            return r;
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                int num = 1;
                if (j > 0 && j < i) {
                    num = r.get(i - 1).get(j - 1) + r.get(i - 1).get(j);
                }
                row.add(num);
            }
            r.add(row);
        }

        return r;
    }

}
