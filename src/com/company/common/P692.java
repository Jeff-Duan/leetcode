package com.company.common;

import java.util.*;

public class P692 {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.containsKey(words[i]) ? map.get(words[i]) + 1 : 1);
        }
        Queue<String> heap = new PriorityQueue<>((s1, s2) -> map.get(s1).equals(map.get(s2)) ? s2.compareTo(s1) : map.get(s1) - map.get(s2));
        for (String key : map.keySet()) {
            heap.offer(key);
            if (heap.size() > k){
                heap.poll();
            }
        }
        List<String> list = new ArrayList<>();
        while (!heap.isEmpty()){
            list.add(heap.poll());
        }
        Collections.reverse(list);
        return list;
    }

}
