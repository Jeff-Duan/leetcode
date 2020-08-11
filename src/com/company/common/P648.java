package com.company.common;

import java.util.List;

public class P648 {

    class TrieNode {
        boolean flag = false;
        TrieNode[] nodes = new TrieNode[26];
    }

    public void build(TrieNode root, String word) {
        TrieNode node = root;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new TrieNode();
            }
            node = node.nodes[index];
        }
        node.flag = true;
    }

    public String search(TrieNode root, String word) {
        TrieNode node = root;
        char[] array = word.toCharArray();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'a';
            if (node.flag) {
                return s.toString();
            }
            if (node.nodes[index] == null) {
                return word;
            }
            s.append((char) ('a' + index));
            node = node.nodes[index];
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String value : dict) {
            build(root, value);
        }
        String[] words = sentence.split(" ");
        String[] s = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            s[i] = search(root, words[i]);
        }
        return String.join(" ", s);
    }

}
