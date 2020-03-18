package com.company.common;

public class P141 {

    public static class ListNode<E> {
        E val;
        ListNode next;

        public ListNode(E e) {
            val = e;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head.next;
        ListNode second = head.next.next;
        while (first != second) {
            if (second == null || second.next == null) {
                return false;
            } else {
                first = first.next;
                second = second.next.next;
            }
        }
        return true;
    }

}
