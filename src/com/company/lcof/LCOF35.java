package com.company.lcof;

public class LCOF35 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node root1 = head;
        while (root1 != null) {
            Node next = root1.next;
            root1.next = new Node(root1.val);
            root1.next.next = next;

            root1 = next;
        }

        Node root2 = head;
        while (root2 != null) {
            Node next = root2.next;
            next.random = root2.random == null ? null : root2.random.next;

            root2 = next.next;
        }

        Node n = new Node(0);
        Node r = n;

        Node root3 = head;
        while (root3 != null) {
            Node next = root3.next.next;

            Node clone = root3.next;
            clone.next = null;
            n.next = clone;
            n = n.next;

            root3.next = next;
            root3 = root3.next;
        }

        return r.next;
    }

}
