package com.company.common;

public class P106 {

    public class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            val = e;
        }
    }

    int[] inorder = null;
    int[] postorder = null;

    public TreeNode helper(int start1, int end1, int start2, int end2) {
        TreeNode root = new TreeNode(this.postorder[end2]);

        if (start1 == end1 && start2 == end2) {
            return root;
        }

        int index = 0;
        for (int i = start1; i <= end1; i++) {
            if (this.inorder[i] == this.postorder[end2]) {
                index = i;
                break;
            }
        }
        int leftCount = index - start1;
        int rightCount = end1 - index;
        if (leftCount > 0) {
            root.left = helper(start1, index - 1, start2, start2 + leftCount - 1);
        }
        if (rightCount > 0) {
            root.right = helper(index + 1, end1, start2 + leftCount, end2 - 1);
        }
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = new int[]{9, 3, 15, 20, 7};
        this.postorder = new int[]{9, 15, 7, 20, 3};

        if (this.inorder.length == 0 || this.postorder.length == 0) {
            return null;
        }
        return helper(0, this.inorder.length - 1, 0, this.postorder.length - 1);
    }

}
