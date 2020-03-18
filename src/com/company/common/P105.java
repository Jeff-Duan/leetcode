package com.company.common;

public class P105 {

    public class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            val = e;
        }
    }

    int[] preorder = null;
    int[] inorder = null;

    public TreeNode helper(int start1, int end1, int start2, int end2) {
        TreeNode root = new TreeNode(this.preorder[start1]);

        if (start1 == end1 && start2 == end2) {
            return root;
        }

        int index = 0;
        for (int i = start2; i <= end2; i++) {
            if (this.inorder[i] == this.preorder[start1]) index = i;
        }

        int leftCount = index - start2;
        int rightCount = end2 - index;
        if (leftCount > 0) {
            root.left = helper(start1 + 1, start1 + leftCount, start2, index - 1);
        }
        if (rightCount > 0) {
            root.right = helper(start1 + leftCount + 1, end1, index + 1, end2);
        }
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        if (this.preorder.length == 0 || this.inorder.length == 0){
            return null;
        }
        return helper(0, this.preorder.length - 1, 0, this.inorder.length - 1);
    }
}
