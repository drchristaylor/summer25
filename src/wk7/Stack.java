package wk7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Stack<E> implements PureStack<E> {
    private List<E> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    @Override
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public E peek() {
        return stack.getFirst();
    }

    @Override
    public E pop() {
        return stack.removeFirst();
    }

    @Override
    public E push(E item) {
        stack.addFirst(item);
        return item;
    }
}
