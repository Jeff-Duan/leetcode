package com.company.lcof;

public class LCOF52 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode r = null;

        int headALength = 0;
        int headBLength = 0;
        ListNode node1 = headA;
        ListNode node2 = headB;
        while (node1 != null) {
            node1 = node1.next;
            headALength++;
        }
        while (node2 != null) {
            node2 = node2.next;
            headBLength++;
        }

        ListNode node3 = headA;
        ListNode node4 = headB;
        if (headALength > headBLength) {
            for (int i = 0; i < headALength - headBLength; i++) {
                node3 = node3.next;
            }
        } else {
            for (int i = 0; i < headBLength - headALength; i++) {
                node4 = node4.next;
            }
        }
        while (node3 != null && node4 != null) {
            if (node3 == node4) {
                r = node3;
                break;
            }
            node3 = node3.next;
            node4 = node4.next;
        }

        return r;
    }

}
