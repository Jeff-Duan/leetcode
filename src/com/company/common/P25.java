package com.company.common;

public class P25 {

    public static class ListNode<E> {
        E val;
        ListNode<E> next;

        public ListNode(E e) {
            val = e;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode root = new ListNode(0);
        root.next = head;

        ListNode res = root;

        ListNode first = root;
        ListNode second = root;

        while (first != null) {
            for (int i = 0; i < k; i++) {
                if (first != null) {
                    first = first.next;
                }
                if (first == null || first.next == null) {
                    return res.next;
                }
            }

            ListNode flag = second.next;

            ListNode before = second.next;
            ListNode node = second.next.next;

            second.next.next = first.next;
            second.next = first;

            while (node != first) {
                ListNode after = node.next;
                node.next = before;
                before = node;
                node = after;
            }
            first.next = before;

            first = flag;
            second = first;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        new P25().reverseKGroup(head, 2);
    }

}
