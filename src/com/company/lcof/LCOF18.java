package com.company.lcof;

public class LCOF18 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode(0);
        root.next = head;

        ListNode before = root;
        while (head != null) {
            if (head.val == val) {
                before.next = head.next;
            }
            before = head;
            head = head.next;
        }
        return root.next;
    }

}
