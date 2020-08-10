package com.company.common;

public class P720 {

    String r = "";

    class TrieNode {
        char val;
        boolean flag = false;
        TrieNode[] node = new TrieNode[26];

        public TrieNode(char val) {
            this.val = val;
        }
    }

    public void build(TrieNode node, String word) {
        TrieNode root = node;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (root.node[index] == null) {
                root.node[index] = new TrieNode(array[i]);
            }
            root = root.node[index];
        }
        root.flag = true;
    }

    public boolean find(TrieNode node, String word) {
        TrieNode root = node;
        char[] array = word.toCharArray();
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (root.node[index] == null) {
                return false;
            }
            if (root.flag) {
                count++;
            }
            root = root.node[index];
        }
        return root.flag && count == word.length() - 1 && (word.length() > r.length() || word.length() == r.length() && word.compareTo(r) < 0);
    }

    public String longestWord(String[] words) {
        TrieNode root = new TrieNode('/');

        for (int i = 0; i < words.length; i++) {
            build(root, words[i]);
        }

        for (int i = 0; i < words.length; i++) {
            if (find(root, words[i])) {
                r = words[i];
            }
        }

        return r;
    }

}
