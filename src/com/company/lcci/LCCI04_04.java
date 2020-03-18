package com.company.lcci;

public class LCCI04_04 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean isBalanced = true;

    public int helper(TreeNode root, int height) {
        if (root == null || !isBalanced) {
            return height;
        }
        int height1 = helper(root.left, height + 1);
        int height2 = helper(root.right, height + 1);
        if (Math.abs(height1 - height2) > 1) {
            isBalanced = false;
        }
        return Math.max(height1, height2);
    }

    public boolean isBalanced(TreeNode root) {
        if (root != null) {
            helper(root, 0);
        }
        return isBalanced;
    }

}
