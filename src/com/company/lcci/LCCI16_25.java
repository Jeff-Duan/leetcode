package com.company.lcci;

import java.util.HashMap;

public class LCCI16_25 {

    class LRUCache {

        HashMap<Integer, Node> map = new HashMap<>();
        Node head;
        Node tail;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            this.capacity = capacity;
        }

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public void addNode(Node node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        public void removeNode(Node node) {
            Node prev = node.prev;
            Node next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        public void moveToHead(Node node) {
            removeNode(node);
            addNode(node);
        }

        public Node removeTail() {
            Node node = tail.prev;
            removeNode(node);
            return node;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                moveToHead(node);
                return node.value;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node node = map.get(key);

                node.value = value;
                moveToHead(node);
            } else {
                Node node = new Node(key, value);

                addNode(node);
                map.put(key, node);
                size++;
                if (size > capacity) {
                    Node tail = removeTail();
                    map.remove(tail.key);
                    size--;
                }
            }
        }
    }

}
