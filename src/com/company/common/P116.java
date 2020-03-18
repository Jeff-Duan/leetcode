package com.company.common;

public class P116 {

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
        while (root != null && root.left != null) {
            Node node = root;

            while (node != null && node.right != null) {
                node.left.next = node.right;

                if (node.next != null) {
                    node.right.next = node.next.left;
                }
                node = node.next;
            }
            root = root.left;
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        connect(root);


    }

}
