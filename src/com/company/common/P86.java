package com.company.common;

public class P86 {

    public static class ListNode<E> {
        E val;
        ListNode next;

        public ListNode(E e) {
            val = e;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode flag = newHead;
        while (head != null) {
            if ((int) head.val < x) {
                flag = head;
                head = head.next;
            } else {
                ListNode node = head;
                ListNode prev = head;
                while (node != null && (int) node.val >= x) {
                    prev = node;
                    node = node.next;
                }
                if (node != null) {
                    prev.next = node.next;
                    node.next = flag.next;
                    flag.next = node;

                    flag = node;
                    head = prev;
                } else {
                    break;
                }
            }
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        partition(head, 3);
    }

}
