package com.company.common;

public class P208 {

    class Trie {
        Trie[] node;
        boolean flag;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            node = new Trie[26];
            flag = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    node.node[index] = new Trie();
                }
                node = node.node[index];
            }
            node.flag = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie node = this;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    return false;
                }
                node = node.node[index];
            }
            return node.flag;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Trie node = this;
            char[] array = prefix.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    return false;
                }
                node = node.node[index];
            }
            return true;
        }
    }

}
