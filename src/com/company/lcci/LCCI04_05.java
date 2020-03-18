package com.company.lcci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCCI04_05 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            count++;

            if (count > 1 && node.val <= list.get(count - 2)) {
                return false;
            }

            root = node.right;
        }

        return true;
    }

}
