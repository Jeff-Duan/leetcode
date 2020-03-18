package com.company.common;

public class P24 {

    public static class ListNode<E> {
        E val;
        ListNode<E> next;

        public ListNode(E e) {
            val = e;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode res = newHead;

        while (newHead.next != null && newHead.next.next != null) {
            ListNode first = newHead.next;
            ListNode second = newHead.next.next;
            newHead.next = second;
            first.next = second.next;
            second.next = first;

            newHead = first;
        }
        return res.next;
    }

}
