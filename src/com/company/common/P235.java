package com.company.common;

public class P235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        TreeNode max = p.val >= q.val ? p : q;
        TreeNode min = p.val >= q.val ? q : p;
        while (root != null) {
            if (root == max) {
                return max;
            }
            if (root == min) {
                return min;
            }
            if (root.val > min.val && root.val < max.val) {
                return root;
            }
            if (root.val < min.val) {
                root = root.right;
            }
            if (root.val > max.val) {
                root = root.left;
            }
        }

        return null;
    }

}
