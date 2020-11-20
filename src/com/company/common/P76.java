package com.company.common;

import java.util.HashMap;
import java.util.Map;

public class P76 {

    public boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            if (!map1.containsKey(entry.getKey()) || map1.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        String result = "";

        char[] source = s.toCharArray();
        char[] target = t.toCharArray();

        Map<Character, Integer> targetMap = new HashMap<>();

        for (int i = 0; i < target.length; i++) {
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
        }

        Map<Character, Integer> sourceMap = new HashMap<>();

        int i = 0;
        for (int j = 0; j < source.length; j++) {
            sourceMap.put(source[j], sourceMap.getOrDefault(source[j], 0) + 1);
            // 判断是否满足全部包含的条件
            while (check(sourceMap, targetMap) && i <= j) {
                if (result.equals("") || result.length() > j - i + 1) {
                    result = s.substring(i, j + 1);
                }
                sourceMap.put(source[i], sourceMap.get(source[i]) - 1);
                i++;
            }
        }

        return result;
    }

}
