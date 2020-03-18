package com.company.common;

public class P876 {

    public static class ListNode<E> {
        E val;
        ListNode next;

        public ListNode(E e) {
            val = e;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;
        while (first.next != null && first.next.next != null) {
            first = first.next.next;
            second = second.next;
        }
        if (first.next == null) {
            return second;
        } else {
            return second.next;
        }
    }

}
