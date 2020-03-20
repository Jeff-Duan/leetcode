package com.company.common;

import java.util.Stack;

public class P173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class BSTIterator {

        Stack<Integer> stack = new Stack<>();

        public BSTIterator(TreeNode root) {
            Stack<TreeNode> s = new Stack<>();
            while (root != null || s.size() > 0) {
                while (root != null) {
                    s.push(root);
                    root = root.right;
                }
                TreeNode node = s.pop();

                stack.push(node.val);

                root = node.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return stack.size() > 0 ? stack.pop() : -1;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return stack.size() > 0;
        }
    }

}
