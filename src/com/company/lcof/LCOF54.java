package com.company.lcof;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCOF54 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            root = node.left;
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        return list.get(k - 1);
    }

}
