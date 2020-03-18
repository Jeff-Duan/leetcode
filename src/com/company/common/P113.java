package com.company.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P113 {

    public class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;

        TreeNode(E e) {
            this.val = e;
        }
    }

    public class Pair {
        TreeNode node;
        Integer val;
        ArrayList<Integer> array;

        public Pair(TreeNode node, Integer val, ArrayList<Integer> array) {
            this.node = node;
            this.val = val;
            this.array = array;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        Stack<Pair> stack = new Stack();
        stack.push(
                new Pair(root, (Integer) root.val, new ArrayList<Integer>() {{
                    add((Integer) root.val);
                }})
        );

        while (stack.size() > 0) {
            Pair pair = stack.pop();
            if (pair.node.left == null && pair.node.right == null) {
                if (pair.val == sum) {
                    res.add(pair.array);
                }
            } else {
                if (pair.node.right != null) {
                    TreeNode right = pair.node.right;
                    Integer rightValue = pair.val + (Integer) pair.node.right.val;
                    pair.array.add((Integer) right.val);

                    stack.push(new Pair(right, rightValue, pair.array));
                }
                if (pair.node.left != null) {
                    TreeNode left = pair.node.left;
                    Integer leftValue = pair.val + (Integer) pair.node.left.val;
                    pair.array.add((Integer) left.val);

                    stack.push(new Pair(left, leftValue, pair.array));
                }
            }

        }
        return res;
    }

}
