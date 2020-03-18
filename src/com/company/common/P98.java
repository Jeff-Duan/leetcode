package com.company.common;

import java.util.Stack;

public class P98 {

    public class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            this.val = e;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Stack stack = new Stack();
        double index = -Double.MAX_VALUE;
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = (TreeNode) stack.pop();
            if ((Integer) node.val <= index) {
                return false;
            } else {
                index = (double) node.val;
            }
            root = node.right;
        }

        return true;
    }

}
