package wk7;

public class CircularQueue<E> implements PureQueue<E> {
    private E[] buffer;
    private int front;
    private int back;
    private boolean isFull;

    public CircularQueue(int capacity) {
        buffer = (E[])new Object[capacity];
        front = 0;
        back = 0;
        isFull = false;
    }

    @Override
    public E peek() {
        return empty() ? null : buffer[front];
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public boolean offer(E item) {
        boolean changed = false;
        if (!isFull) {
            buffer[back] = item;
            back = (back + 1) % buffer.length;
        }
        return changed;
    }

    @Override
    public boolean empty() {
        return !isFull && front == back;
    }
}
