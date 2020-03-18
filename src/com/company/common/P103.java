package com.company.common;

import java.util.*;

public class P103 {

    public static class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            val = e;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> array = new ArrayList<>();

        if (root == null) {
            return array;
        }

        Stack stack = new Stack();
        Queue queue = new LinkedList();
        queue.add(root);

        boolean asc = true;

        while (!queue.isEmpty()) {
            List<Integer> l = new ArrayList<>();

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = (TreeNode) queue.poll();

                if (!asc) {
                    stack.push(node.val);
                } else {
                    l.add((Integer) node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!asc) {
                while (stack.size() > 0) {
                    l.add((Integer) stack.pop());
                }
            }
            asc = !asc;

            array.add(l);
        }

        return array;
    }

}