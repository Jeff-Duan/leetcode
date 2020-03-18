package com.company.lcof;

public class LCOF06 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ListNode before = null;
        ListNode after;
        int count = 0;
        while (head != null) {
            after = head.next;
            head.next = before;
            before = head;

            head = after;
            count++;
        }

        int[] r = new int[count];
        int index = 0;
        while (before != null) {
            r[index++] = before.val;
            before = before.next;
        }

        return r;
    }

}
