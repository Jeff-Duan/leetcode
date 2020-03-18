package com.company.lcof;

public class LCOF33 {

    int[] postorder;

    public boolean helper(int start, int end) {
        if (start >= end) {
            return true;
        }

        int index = start;
        for (int i = start; i < end; i++) {
            if (postorder[i] > postorder[end]) {
                index = i;
                break;
            }
        }
        for (int i = index; i < end; i++) {
            if (postorder[i] < postorder[end]) {
                return false;
            }
        }

        return helper(start, index - 1) && helper(index, end - 1);
    }

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;

        if (postorder.length <= 2) {
            return true;
        }
        return helper(0, postorder.length - 1);
    }

}
