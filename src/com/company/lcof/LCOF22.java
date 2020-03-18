package com.company.lcof;

public class LCOF22 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode first = root;
        while (k > 0) {
            if (first == null) {
                return null;
            } else {
                first = first.next;
            }
            k--;
        }

        ListNode second = root;
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }

}
