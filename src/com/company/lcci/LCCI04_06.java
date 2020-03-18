package com.company.lcci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LCCI04_06 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || stack.size() > 0) {
            while (root != null) {
                stack.push(root);
                root = root.right;
            }
            TreeNode node = stack.pop();
            if (node == p) {
                break;
            }
            list.add(node);
            root = node.left;
        }
        return list.size() == 0 ? null : list.get(list.size() - 1);
    }

}
