package com.company.common;

import java.util.ArrayList;
import java.util.List;

public class P1023 {

    class Trie {
        Trie[] node = new Trie[52];
        boolean flag = false;
    }

    public void build(Trie root, String word) {
        Trie node = root;
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int index = array[i] - 'A';
	    index = index >= 26 ? index - 6 : index;
            if (node.node[index] == null) {
                node.node[index] = new Trie();
            }
            node = node.node[index];
        }
        node.flag = true;
    }

    public Boolean search(Trie root, String word) {
        Trie node = root;
	Boolean flag = false;
	char[] array = word.toCharArray();
	for (int i = 0; i < array.length; i++) {
	    int index = array[i] - 'A';
            index = index >= 26 ? index - 6 : index;
	    if (node.node[index] == null) {
		if (index >= 26) {
		    continue;
		} else {
		    return false;
		}
	    }
	    node = node.node[index];
            if (node.flag) {
	        flag = true;
	    }
	}
	return flag;
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Trie root = new Trie();
        build(root, pattern);
	List<Boolean> r = new ArrayList<>();
	for (int i = 0; i < queries.length; i++) {
	    r.add(search(root, queries[i]));
	}
        return r;
    }

}
