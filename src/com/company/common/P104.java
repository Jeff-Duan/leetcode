package com.company.common;

import java.util.Stack;

public class P104 {

    public class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            this.val = e;
        }
    }

    public class Pair {
        TreeNode node;
        Integer val;

        public Pair(TreeNode node, Integer val) {
            this.node = node;
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        int depth = 0;

        if (root == null) {
            return depth;
        }

        Stack<Pair> stack = new Stack();
        stack.push(new Pair(root, 1));
        while (stack.size() > 0) {
            Pair pair = stack.pop();
            if (pair.val > depth) {
                depth = pair.val;
            }
            if (pair.node.right != null) {
                stack.push(new Pair(pair.node.right, pair.val + 1));
            }
            if (pair.node.left != null) {
                stack.push(new Pair(pair.node.left, pair.val + 1));
            }
        }
        return depth;
    }

}
