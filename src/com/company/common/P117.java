package com.company.common;

public class P117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node res = root;
        while (root != null) {
            Node dummy = new Node();
            Node tmp = dummy;

            Node node = root;
            while (node != null) {
                if (node.left != null) {
                    tmp.next = node.left;
                    tmp = node.left;
                }
                if (node.right != null) {
                    tmp.next = node.right;
                    tmp = node.right;
                }
                node = node.next;
            }
            root = dummy.next;
        }
        return res;
    }

}
