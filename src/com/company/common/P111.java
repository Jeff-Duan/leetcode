package com.company.common;

import java.util.LinkedList;
import java.util.Queue;

public class P111 {

    public class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            this.val = e;
        }
    }

    public int minDepth(TreeNode root) {
        int depth = 0;
        boolean bool = false;

        if (root == null) {
            return depth;
        }

        Queue queue = new LinkedList();
        queue.add(root);
        while (queue.size() > 0) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = (TreeNode) queue.poll();
                if (node.left == null && node.right == null) {
                    bool = true;
                    break;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (bool) {
                break;
            }
        }
        return depth;
    }

}
