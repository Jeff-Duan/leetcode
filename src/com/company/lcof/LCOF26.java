package com.company.lcof;

public class LCOF26 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }

        if (A == null) {
            return false;
        }

        if (A.val == B.val) {
            return helper(A.left, B.left) && helper(A.right, B.right);
        }

        return false;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }

        boolean r = false;

        if (A.val == B.val) {
            r = helper(A, B);
        } else {
            r = isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        return r;
    }

}
