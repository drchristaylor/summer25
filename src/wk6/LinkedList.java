package wk6;

import java.util.*;

public class LinkedList<E> implements List<E> {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        System.out.println(args[2]);
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

    // Adding to the front for now... will fix to add to back tomorrow
    @Override
    public boolean add(E e) {
        head = new Node(e, head);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

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