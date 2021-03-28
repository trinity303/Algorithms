package algorithms.dequeue.based_array;

import algorithms.dequeue.Dequeue;

public class CyclicArrayDequeue implements Dequeue {

    private final short[] cyclicArray;
    private final int capacity;
    private int head, tail;

    public CyclicArrayDequeue(int capacity) {
        this.capacity = capacity;
        cyclicArray = new short[capacity];
        head = -1;
        tail = -1;
    }

    @Override
    public void pushFront(short value) {
        if (isDequeueFull()) {
            System.out.println("error");

            return;
        }

        if (head == -1 && tail == -1) {
            head = tail = 0;
            cyclicArray[head] = value;

            return;
        }

        if (head == 0) {
            head = capacity - 1;
            cyclicArray[head] = value;

            return;
        }

        head--;
        cyclicArray[head] = value;
    }

    @Override
    public void pushBack(short value) {
        if (isDequeueFull()) {
            System.out.println("error");

            return;
        }

        if (head == -1 && tail == -1) {
            head = tail = 0;
            cyclicArray[tail] = value;

            return;
        }

        if (tail == capacity - 1) {
            tail = 0;
            cyclicArray[tail] = value;

            return;
        }

        tail++;
        cyclicArray[tail] = value;
    }

    @Override
    public void popFront() {
        if (isDequeueEmpty()) {
            System.out.println("error");

            return;
        }

        short value = cyclicArray[head];
        cyclicArray[head] = 0;

        if (head == tail) {
            head = tail = -1;
            System.out.println(value);

            return;
        }

        if (head == capacity - 1) {
            head = 0;
            System.out.println(value);

            return;
        }

        head++;
        System.out.println(value);
    }

    @Override
    public void popBack() {
        if (isDequeueEmpty()) {
            System.out.println("error");

            return;
        }

        short value = cyclicArray[tail];
        cyclicArray[tail] = 0;

        if (tail == head) {
            head = tail = -1;
            System.out.println(value);

            return;
        }

        if (tail == 0) {
            tail = capacity - 1;
            System.out.println(value);

            return;
        }

        tail--;
        System.out.println(value);
    }

    private boolean isDequeueFull() {
        return head == 0
                && tail == cyclicArray.length - 1
                || head == tail + 1;
    }

    private boolean isDequeueEmpty() {
        return head == -1 && tail == -1;
    }
}
