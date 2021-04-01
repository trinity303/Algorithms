package algorithms.queue.based_linked_list;

import algorithms.queue.Queue;

public class LinkedQueue<T> implements Queue<T> {

    private ListNode<T> head;
    private ListNode<T> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public T get() {
        if (size > 0) {
            T result = head.value;
            head = head.next;
            size = size - 1;

            return result;
        }

        return null;
    }

    @Override
    public void put(T value) {
        ListNode<T> node = new ListNode<>(value);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
        size = size + 1;
    }

    @Override
    public int size() {
        return size;
    }
}