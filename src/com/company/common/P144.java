package com.company.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P144 {

    public static class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            val = e;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> array = new ArrayList<>();
        Stack stack = new Stack();

        if (root == null) {
            return array;
        }

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                array.add((Integer) root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = (TreeNode) stack.pop();
        }

        return array;
    }

}
