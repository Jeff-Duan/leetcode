package com.company.common;

import java.util.HashMap;
import java.util.Map;

public class P409 {

    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int r = 0;

        boolean flag = false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char k = s.charAt(i);
            int v = map.containsKey(k) ? map.get(k) + 1 : 1;
            map.put(k, v);
        }

        for (int v : map.values()) {
            if ((v & 1) == 0) {
                r += v;
            } else {
                r += v - 1;
                flag = true;
            }
        }

        return flag ? ++r : r;
    }

}
