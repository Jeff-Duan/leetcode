package com.company.lcof;

import java.util.HashMap;
import java.util.Map;

public class LCOF50 {

    public char firstUniqChar(String s) {
        char[] array = s.toCharArray();

        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], true);
            } else {
                map.put(array[i], false);
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (!map.get(array[i])) {
                return array[i];
            }
        }

        return ' ';
    }

}
