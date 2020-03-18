package com.company.lcof;

public class LCOF24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode before = null;
        ListNode after;

        while (head != null) {
            after = head.next;
            head.next = before;
            before = head;

            head = after;
        }
        return before;
    }

}
