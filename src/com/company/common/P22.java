package com.company.common;

import java.util.ArrayList;
import java.util.List;

public class P22 {

    List<String> list = new ArrayList<>();

    public void helper(int i, int j, String k) {
        if (i == 0 && j == 0) {
            list.add(k);
            return;
        }
        if (i > 0) {
            helper(i - 1, j, k + "(");
        }
        if (j > i) {
            helper(i, j - 1, k + ")");
        }
    }

    public List<String> generateParenthesis(int n) {
        helper(n, n, "");
        return list;
    }

}
