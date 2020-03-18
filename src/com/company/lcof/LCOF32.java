package com.company.lcof;

import java.util.*;

public class LCOF32 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> r = new ArrayList<>();

        if (root == null) {
            return r;
        }

        boolean flag = true;

        Stack<TreeNode> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();

                if (flag) {
                    list.add(node.val);
                } else {
                    stack.push(node);
                }


                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }

            if (!flag) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop().val);
                }
            }
            flag = !flag;

            r.add(list);
        }
        return r;
    }

}
