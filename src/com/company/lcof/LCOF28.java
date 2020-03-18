package com.company.lcof;

public class LCOF28 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null){
            return false;
        }
        if (b == null){
            return false;
        }

        if (a.val == b.val) {
            return helper(a.left, b.left) && helper(a.right, b.right);
        }

        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root.left, root.right);
    }

}
