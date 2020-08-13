package com.company.common;

import java.util.LinkedList;
import java.util.Queue;

public class P677 {

    class MapSum {
        MapSum[] node;
        boolean flag;
        int value;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            node = new MapSum[26];
            flag = true;
            value = 0;
        }

        public void insert(String key, int val) {
            MapSum node = this;
            char[] array = key.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    node.node[index] = new MapSum();
                }
                node = node.node[index];
            }
            node.flag = true;
            node.value = val;
        }

        public int sum(String prefix) {
            MapSum node = this;
            char[] array = prefix.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    return 0;
                }
                node = node.node[index];
            }

            int r = 0;

            Queue<MapSum> queue = new LinkedList();
            queue.add(node);
            while (queue.size() > 0) {
                MapSum mapSum = queue.poll();
                if (mapSum.flag){
                    r += mapSum.value;
                }
                for (MapSum sum:mapSum.node) {
                    if (sum != null){
                        queue.add(sum);
                    }
                }
            }

            return r;
        }
    }

}
