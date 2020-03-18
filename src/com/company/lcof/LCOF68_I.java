package com.company.lcof;

public class LCOF68_I {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = null;

        if (root == null) {
            return node;
        }

        if (p.val == root.val || q.val == root.val) {
            node = root;
        } else if (p.val < root.val && q.val > root.val || p.val > root.val && q.val < root.val) {
            node = root;
        } else {
            if (p.val < root.val && q.val < root.val && root.left != null) {
                node = lowestCommonAncestor(root.left, p, q);
                if (node != null) {
                    return node;
                }
            }
            if (p.val > root.val && q.val > root.val && root.right != null) {
                node = lowestCommonAncestor(root.right, p, q);
                if (node != null) {
                    return node;
                }
            }
        }

        return node;
    }

}
