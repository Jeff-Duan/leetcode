package com.company.common;

import java.util.Stack;

public class P112 {

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

    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<Pair> stack = new Stack();

        if (root != null) {
            stack.push(new Pair(root, (Integer) root.val));
        }

        while (stack.size() > 0) {
            Pair pair = (Pair) stack.pop();
            if (pair.node.left == null && pair.node.right == null) {
                if (pair.val == sum) {
                    return true;
                }
            } else {
                if (pair.node.right != null) {
                    stack.push(new Pair(pair.node.right, pair.val + (Integer) pair.node.right.val));
                }
                if (pair.node.left != null) {
                    stack.push(new Pair(pair.node.left, pair.val + (Integer) pair.node.left.val));
                }
            }
        }
        return false;
    }

}
