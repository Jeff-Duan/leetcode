package com.company.lcof;

public class LCOF07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int[] preorder;
    int[] inorder;

    public TreeNode helper(int start1, int end1, int start2, int end2) {
        TreeNode root = new TreeNode(this.preorder[start1]);

        if (start1 != end1 || start2 != end2) {
            int index = 0;
            for (int i = start2; i <= end2; i++) {
                if (this.preorder[start1] == this.inorder[i]) {
                    index = i;
                    break;
                }
            }

            int leftTreeLength = index - start2;
            int rightTreeLength = end2 - index;
            if (leftTreeLength > 0) {
                root.left = helper(start1 + 1, start1 + leftTreeLength, start2, index - 1);
            }
            if (rightTreeLength > 0) {
                root.right = helper(start1 + leftTreeLength + 1, end1, index + 1, end2);
            }
        }

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return helper(0, preorder.length - 1, 0, inorder.length - 1);
    }

}
