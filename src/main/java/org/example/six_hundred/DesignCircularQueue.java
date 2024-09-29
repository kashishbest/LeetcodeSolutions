package org.example.six_hundred;

import java.util.Deque;
import java.util.LinkedList;

public class DesignCircularQueue {
    class MyCircularDeque {
        Deque<Integer> deque;
        int size;
        public MyCircularDeque(int k) {
            deque = new LinkedList();
            this.size = k;
        }

        public boolean insertFront(int value) {
            if(deque.size() == size) return false;
            deque.addFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if(deque.size() == size) return false;
            deque.addLast(value);
            return true;
        }

        public boolean deleteFront() {
            if(deque.size() == 0) return false;
            deque.removeFirst();
            return true;
        }

        public boolean deleteLast() {
            if(deque.size() == 0) return false;
            deque.removeLast();
            return true;
        }

        public int getFront() {
            if(deque.size() == 0) return -1;
            return deque.peekFirst();

        }

        public int getRear() {
            if(deque.size() == 0) return -1;
            return deque.peekLast();
        }

        public boolean isEmpty() {
            return deque.size() == 0;
        }

        public boolean isFull() {
            return deque.size() == size;
        }
    }
}
