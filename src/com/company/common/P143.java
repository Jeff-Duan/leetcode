package com.company.common;

public class P143 {

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
        return second;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;

            head = next;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode middleNode = middleNode(head);
        if (middleNode != null && middleNode.next != null) {
            ListNode node = middleNode.next;
            node = reverseList(node);

            while (head != null && node != null) {
                middleNode.next = node.next;
                node.next = head.next;
                head.next = node;

                head = head.next.next;
                node = middleNode.next;
            }
        }
    }

}
