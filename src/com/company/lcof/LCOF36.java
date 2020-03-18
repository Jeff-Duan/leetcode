package com.company.lcof;

import java.util.Stack;

public class LCOF36 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    public Node treeToDoublyList(Node root) {
        Node head = new Node();

        if (root == null) {
            return head.right;
        }

        Node flag = head;
        Stack<Node> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            Node node = stack.pop();

            flag.right = node;
            node.left = flag;
            flag = node;

            root = node.right;
        }
        head.right.left = flag;
        flag.right = head.right;

        return head.right;
    }

}
