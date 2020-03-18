package com.company.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P102 {

    public static class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            val = e;
        }
    }

    List<List<Integer>> array = new ArrayList<>();

    // 递归
    public void levelOrder1(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (array.size() == level) {
            array.add(new ArrayList<>());
        }
        array.get(level).add((Integer) root.val);
        if (root.left != null) {
            levelOrder1(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrder1(root.right, level + 1);
        }
    }

    // 迭代
    public void levelOrder2(TreeNode root) {
        if (root == null) {
            return;
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
                TreeNode node = (TreeNode) queue.remove();
                array.get(level).add((Integer) node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //levelOrder1(root, 0);
        levelOrder2(root);
        return array;
    }

}
