package com.company.common;

public class P572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode i, TreeNode j) {
        if (i == null && j == null) {
            return true;
        }
        if (i == null || j == null || i.val != j.val) {
            return false;
        }
        return isSameTree(i.left, j.left) && isSameTree(i.right, j.right);
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

}
