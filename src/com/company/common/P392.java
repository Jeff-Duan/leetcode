package com.company.common;

public class P392 {

    public boolean isSubsequence(String s, String t) {
        char[] p = s.toCharArray();
        char[] q = t.toCharArray();

        if (p.length == 0) {
            return true;
        }
        if (q.length == 0) {
            return false;
        }

        int index = 0;

        for (int i = 0; i < q.length; i++) {
            if (q[i] == p[index]) {
                index++;
            }
            if (p.length == index) {
                return true;
            }
        }
        return false;
    }

}
