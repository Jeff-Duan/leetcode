package com.company.common;

public class P160 {

    public static class ListNode<E> {
        E val;
        ListNode next;

        public ListNode(E e) {
            val = e;
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        ListNode node1 = headA;
        while (node1 != null) {
            countA++;
            node1 = node1.next;
        }
        int countB = 0;
        ListNode node2 = headB;
        while (node2 != null) {
            countB++;
            node2 = node2.next;
        }

        int count = countA > countB ? countA - countB : countB - countA;
        if (countA > countB) {
            for (int i = 0; i < count; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < count; i++) {
                headB = headB.next;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null || headB == null) {
                return null;
            }
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(8);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(0);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(8);
        head2.next.next.next.next = new ListNode(4);
        head2.next.next.next.next.next = new ListNode(5);


        getIntersectionNode(head1, head2);
    }

}
