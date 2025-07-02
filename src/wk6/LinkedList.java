package wk6;

import java.util.*;

public class LinkedList<E> implements List<E> {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(args[1]);
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }

        Node(E value) {
            this(value, null);
        }
    }

    private Node<E> head;

    public LinkedList() {
        head = null;
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> walker = head;
        while (walker != null) {
            size++;
            walker = walker.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(Object target) {
        boolean found = false;
        Node<E> walker = head;
        while (!found && walker != null) {
            found = Objects.equals(target, walker.value);
            walker = walker.next;
        }
        return found;
    }

    @Override
    public int indexOf(Object target) {
        boolean found = false;
        int index = -1;
        Node<E> walker = head;
        while (!found && walker != null) {
            index++;
            found = Objects.equals(target, walker.value);
            walker = walker.next;
        }
        return found ? index : -1;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = new Node<>(e);
        } else {
            Node<E> walker = head;
            while (walker.next != null) {
                walker = walker.next;
            }
            walker.next = new Node<>(e);
        }
        return true;
    }

    @Override
    public boolean remove(Object target) {
        boolean removed = false;
        if (head != null && Objects.equals(head.value, target)) {
            head = head.next;
            removed = true;
        } else {
            Node<E> walker = head;
            while (!removed && walker != null) {
                if (walker.next != null && Objects.equals(walker.next.value, target)) {
                    walker.next = walker.next.next;
                    removed = true;
                }
                walker = walker.next;
            }
        }
        return removed;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public E get(int index) {
        Node<E> walker = head;
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        for(int i = 0; i < index; i++){
            walker = walker.next;
        }
        return walker.value;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("error message");
        }
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> walker = head;
            for(int i = 0; i < index - 1; i++){
                walker = walker.next;
            }
            walker.next = new Node<>(element, walker.next);
        }
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return List.of();
    }
}