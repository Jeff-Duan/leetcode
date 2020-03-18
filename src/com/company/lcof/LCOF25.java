package com.company.lcof;

public class LCOF25 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode root = new ListNode(0);

        ListNode r = root;
        ListNode first = l1;
        ListNode second = l2;
        while (first != null && second != null) {
            if (first.val < second.val) {
                root.next = new ListNode(first.val);
                first = first.next;
            } else {
                root.next = new ListNode(second.val);
                second = second.next;
            }
            root = root.next;
        }
        if (first == null) {
            root.next = second;
        } else {
            root.next = first;
        }

        return r.next;
    }

}
