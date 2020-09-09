package com.company.common;

import java.util.ArrayList;
import java.util.List;

public class P119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> r = new ArrayList<>(rowIndex + 1);

        for (int i = 0; i < rowIndex + 1; i++) {
            r.add(1);
            for (int j = i - 1; j > 0; j--) {
                r.set(j, r.get(j - 1) + r.get(j));
            }
        }

        return r;
    }

}
