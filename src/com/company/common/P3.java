package com.company.common;

import java.util.HashMap;
import java.util.Map;

public class P3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        char[] array = s.toCharArray();

        int r = 0;

        int left = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                left = Math.max(left, map.get(array[i]) + 1);
            }
            map.put(array[i], i);
            r = Math.max(r, i - left + 1);
        }

        return r;
    }

}
