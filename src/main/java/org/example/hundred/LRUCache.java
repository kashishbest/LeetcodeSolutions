package org.example.hundred;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node previous;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.previous = null;
        this.next = null;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
    }

    public void readjust(Node node) {
        if (node != head && node == tail) {
            tail = tail.previous;
            node.next = head;
            node.previous = null;
            head.previous=node;
            head = node;
        } else if (node != head) {
            if (node.previous != null) node.previous.next = node.next;
            if (node.next != null) node.next.previous = node.previous;
            node.previous = null;
            node.next = head;
            head = node;
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            readjust(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;

            readjust(node);
            head = node;
        } else {
            node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.key);
                tail = tail.previous;
                if (tail == null) {
                    head = null;
                    tail = null;
                } else {
                    tail.next = null;
                }
            }
            map.put(key, node);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head.previous = node;
                node.next = head;
                head = node;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */