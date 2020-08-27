package com.company.common;

public class P676 {

    class MagicDictionary {
        MagicDictionary[] node = new MagicDictionary[26];
        boolean flag = false;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            for (String word : dictionary) {
                MagicDictionary node = this;
                char[] array = word.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    int index = array[i] - 'a';
                    if (node.node[index] == null) {
                        node.node[index] = new MagicDictionary();
                    }
                    node = node.node[index];
                }
                node.flag = true;
            }
        }

        public boolean search(String searchWord) {
            return _search(searchWord, 0, this, false);
        }

        public boolean _search(String word, int index, MagicDictionary node, boolean hasChange) {
            if (index == word.length()) {
                return node.flag && hasChange;
            }
            for (int i = 0; i < 26; i++) {
                if (node.node[i] != null) {
                    if (word.charAt(index) - 'a' == i && _search(word, index + 1, node.node[i], hasChange)) {
                        return true;
                    }
                    if (word.charAt(index) - 'a' != i && !hasChange && _search(word, index + 1, node.node[i], true)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

}
