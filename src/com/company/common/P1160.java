package com.company.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class P1160 {

    public int countCharacters(String[] words, String chars) {
        if (words.length == 0 || chars.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        int r = 0;

        char[] array = chars.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (map1.containsKey(array[i])) {
                map1.put(array[i], map1.get(array[i]) + 1);
            } else {
                map1.put(array[i], 1);
            }
        }

        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            for (int j = 0; j < word.length; j++) {
                if (map2.containsKey(word[j])) {
                    map2.put(word[j], map2.get(word[j]) + 1);
                } else {
                    map2.put(word[j], 1);
                }
            }

            boolean bool = true;

            Set<Character> set = map2.keySet();
            Iterator<Character> iterator = set.iterator();
            while (iterator.hasNext()) {
                Character text = iterator.next();
                if (!map1.containsKey(text) || map2.get(text) > map1.get(text)) {
                    bool = false;
                    break;
                }
            }

            if (bool) {
                r += word.length;
            }

            map2.clear();
        }

        return r;
    }

}
