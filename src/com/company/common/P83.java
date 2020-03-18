package com.company.common;

public class P83 {

    public static class ListNode<E> {
        E val;
        ListNode<E> next;

        public ListNode(E e) {
            val = e;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode res = newHead;

        while (head != null && head.next != null) {
            if (head.val != head.next.val) {
                head = head.next;
            } else {
                ListNode node = head;
                while (node.val == head.val) {
                    node = node.next;
                    if (node == null) {
                        head.next = null;
                        break;
                    }
                }
                head.next = node;
                head = node;
            }
        }
        return res.next;
    }

}
