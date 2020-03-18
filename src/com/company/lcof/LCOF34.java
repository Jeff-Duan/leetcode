package com.company.lcof;

import java.util.ArrayList;
import java.util.List;

public class LCOF34 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> r = new ArrayList<>();
    List<Integer> t = new ArrayList<>();
    int sum;

    public void helper(TreeNode root, int k) {
        t.add(root.val);

        if (k == sum && root.left == null && root.right == null) {
            r.add(new ArrayList<>(t));
        } else {
            if (root.left != null) {
                helper(root.left, k + root.left.val);

            }
            if (root.right != null) {
                helper(root.right, k + root.right.val);
            }
        }

        t.remove(t.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;

        if (root == null) {
            return r;
        }

        helper(root, root.val);

        return r;
    }

}
