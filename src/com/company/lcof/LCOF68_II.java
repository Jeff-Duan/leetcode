package com.company.lcof;

import java.util.LinkedList;
import java.util.List;

public class LCOF68_II {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> list = new LinkedList<>();

    public LinkedList<TreeNode> getTreeNodePath(TreeNode root, TreeNode r) {
        list.add(root);
        if (root.val == r.val) {
            return new LinkedList<>(list);
        } else {
            if (root.left != null) {
                LinkedList<TreeNode> list1 = getTreeNodePath(root.left, r);
                if (list1 != null) {
                    return list1;
                }
            }
            if (root.right != null) {
                LinkedList<TreeNode> list2 = getTreeNodePath(root.right, r);
                if (list2 != null) {
                    return list2;
                }
            }
        }
        list.remove(list.size() - 1);

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        LinkedList<TreeNode> list1 = getTreeNodePath(root, p);
        list.clear();
        LinkedList<TreeNode> list2 = getTreeNodePath(root, q);
        list.clear();

        TreeNode r = null;
        while (true) {
            TreeNode node1 = list1.pop();
            TreeNode node2 = list2.pop();
            if (node1.val == node2.val) {
                r = node1;
            } else {
                break;
            }
            if (list1.size() == 0 || list2.size() == 0){
                break;
            }
        }
        return r;
    }

}
