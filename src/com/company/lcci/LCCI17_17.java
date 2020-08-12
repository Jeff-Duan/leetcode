package com.company.lcci;

import java.util.ArrayList;
import java.util.List;

public class LCCI17_17 {

    class TrieNode {
        boolean flag = false;
        TrieNode[] nodes = new TrieNode[26];
        List<Integer> values = new ArrayList<>();
    }

    public void build(TrieNode root, String word, int value) {
        TrieNode node = root;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new TrieNode();
            }
            node.nodes[index].values.add(value++);
            node = node.nodes[index];
        }
        node.flag = true;
    }

    public int[] search(TrieNode root, String word) {
        TrieNode node = root;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (node.nodes[index] == null) {
                return new int[]{};
            }
            node = node.nodes[index];
        }
        int[] r = node.values.stream().mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < r.length; i++) {
            r[i] -= word.length();
        }
        return r;
    }

    public int[][] multiSearch(String big, String[] smalls) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < big.length(); i++) {
            build(root, big.substring(i), i);
        }
        int[][] r = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            r[i] = search(root, smalls[i]);
        }
        return r;
    }

}
