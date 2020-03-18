package com.company.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P94 {

    public static class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            val = e;
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // 中序遍历
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add((Integer) node.val);
            root = node.right;
        }

        // 前序遍历
        /*while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add((Integer) root.val);
                stack.push(root.right);
                root = root.left;
            }
            root = stack.pop();
        }*/

        //后序遍历
        /*while (root != null || !stack.isEmpty()) {
            while (root != null) {
                list.add((Integer) root.val);
                stack.push(root.left);
                root = root.right;
            }
            root = stack.pop();
        }
        Collections.reverse(list);*/

        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        inorderTraversal(root);
    }

}
