package wk7;

import java.util.LinkedList;

public class Queue<E> implements PureQueue<E> {
    // Remove from front, add to back
    private LinkedList<E> queue;
    private int capacity;
    private static int DEFAULT_CAPACITY = 8;

    public Queue(int capacity) {
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public E peek() {
        E frontOfQueue = null;
        if (!queue.isEmpty()) {
            frontOfQueue = queue.getFirst();
        }
        return frontOfQueue;
    }

    @Override
    public E poll() {
        E frontOfQueue = null;
        if (!queue.isEmpty()) {
            frontOfQueue = queue.removeFirst();
        }
        return frontOfQueue;
    }

    @Override
    public boolean offer(E item) {
        boolean changed = false;
        if (queue.size() < capacity) {
            changed = queue.add(item);
        }
        return changed;
    }

    @Override
    public boolean empty() {
        return queue.isEmpty();
    }
}
