package com.company.common;

public class P19 {

    public static class ListNode<E> {
        E value;
        ListNode<E> next;

        public ListNode(E e) {
            value = e;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return null;
        }

        ListNode node1 = head;
        ListNode node2 = head;

        for (int i = 1; i < n; i++) {
            if (node1.next == null) {
                return null;
            } else {
                node1 = node1.next;
            }
        }

        ListNode prev = null;
        while (node1.next != null) {
            node1 = node1.next;
            prev = node2;
            node2 = node2.next;
        }

        if (prev == null) {
            head = node2.next;
        } else {
            prev.next = node2.next;
        }
        return head;
    }
}
