package wk7;

public interface PureQueue<E> {
    E peek();
    E poll();
    boolean offer(E item);
    boolean empty();
}
