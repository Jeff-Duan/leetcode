package com.company.common;

public class P92 {

    public static class ListNode<E> {
        E val;
        ListNode next;

        public ListNode(E e) {
            val = e;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode flag = newHead;
        ListNode first = newHead;
        for (int i = 0; i < m; i++) {
            flag = first;
            first = first.next;
        }

        int count = n - m;

        ListNode second = first;
        ListNode prev = first;
        ListNode next = first.next;
        while (count > 0) {
            second = next;

            next = second.next;
            second.next = prev;
            prev = second;

            count--;
        }

        first.next = next;
        flag.next = second;

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reverseBetween(head, 2, 4);
    }

}
