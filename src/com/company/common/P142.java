package com.company.common;

public class P142 {

    public static class ListNode<E> {
        E val;
        ListNode next;

        public ListNode(E e) {
            val = e;
        }
    }

    public ListNode detectCycle(ListNode head) {
        // 判断是否有环
        if (head == null || head.next == null) {
            return null;
        }
        ListNode first = head.next;
        ListNode second = head.next.next;
        while (first != second) {
            if (second == null || second.next == null) {
                return null;
            } else {
                first = first.next;
                second = second.next.next;
            }
        }
        // 环中节点个数
        int count = 1;
        second = second.next;
        while (first != second) {
            count++;
            first = first.next;
            second = second.next.next;
        }
        // 环的入口节点
        first = head;
        second = head;
        for (int i = 0; i < count; i++) {
            first = first.next;
        }
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return first;
    }

}
