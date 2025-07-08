package wk7;

public interface PureStack<E> {
    boolean empty();
    E peek();
    E pop();
    E push(E item);
}
