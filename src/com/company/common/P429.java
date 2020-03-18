package com.company.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P429 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> array = new ArrayList<>();

        if (root == null) {
            return array;
        }

        Queue queue = new LinkedList();
        queue.add(root);
        int level = 0;
        while (queue.size() > 0) {
            if (array.size() == level) {
                array.add(new ArrayList<>());
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = (Node) queue.poll();
                array.get(level).add(node.val);
                queue.addAll(node.children);
            }
            level++;
        }

        return array;
    }
}
