package com.company.common;

public class P211 {

    class WordDictionary {
        WordDictionary[] node;
        boolean flag;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            node = new WordDictionary[26];
            flag = false;
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            WordDictionary node = this;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    node.node[index] = new WordDictionary();
                }
                node = node.node[index];
            }
            node.flag = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            WordDictionary node = this;
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; i++) {
                if (array[i] == '.') {
                    for (int j = 0; j < node.node.length; j++) {
                        if (node.node[j] != null) {
                            boolean r = node.node[j].search(word.substring(i + 1));
                            if (r) {
                                return r;
                            }
                        }
                    }
                    return false;
                }
                int index = array[i] - 'a';
                if (node.node[index] == null) {
                    return false;
                }
                node = node.node[index];
            }
            return node.flag;
        }
    }

}
