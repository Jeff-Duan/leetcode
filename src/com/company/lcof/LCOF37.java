package com.company.lcof;

import java.util.LinkedList;
import java.util.Queue;

public class LCOF37 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }

            StringBuilder r = new StringBuilder("[");

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node != null) {
                    r.append(node.val + ",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    r.append("null,");
                }
            }

            r.substring(0, r.length() - 1);
            r.append("]");

            return r.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            System.out.println(data);
            String[] tree = data.substring(1, data.length() - 1).split(",");

            if (tree.length == 0 || tree[0].isEmpty()) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(tree[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int index = 1;

            while (queue.size() > 0) {
                TreeNode r = queue.poll();
                if (r != null) {
                    TreeNode i = "null".equals(tree[index]) ? null : new TreeNode(Integer.parseInt(tree[index]));
                    index++;
                    TreeNode j = "null".equals(tree[index]) ? null : new TreeNode(Integer.parseInt(tree[index]));
                    index++;

                    r.left = i;
                    r.right = j;
                    queue.add(i);
                    queue.add(j);
                }
            }

            return root;
        }
    }

}
