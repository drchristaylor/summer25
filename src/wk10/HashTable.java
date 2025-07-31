package wk10;

import javafx.scene.chart.ScatterChart;

import java.util.*;

public class HashTable<E> implements Set<E> {
    private static int DEFAULT_CAPACITY = 12;
    private int size;
    private List<E>[] table;

    public HashTable(int capacity) {
        size = 0;
        table = new LinkedList[capacity];
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        int bucketIndex = o.hashCode() % table.length;
        return table[bucketIndex] != null && table[bucketIndex].contains(o);
    }

    @Override
    public void clear() {
        size = 0;
        Arrays.fill(table, null);
    }

    @Override
    public boolean add(E e) {
        int bucketIndex = e.hashCode() % table.length;
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<>();
        }
        boolean changed = !contains(e);
        if (changed) {
            table[bucketIndex].add(e);
        }
        return changed;
    }

    @Override
    public boolean remove(Object o) {
        int bucketIndex = o.hashCode() % table.length;
        List<E> bucket = table[bucketIndex];
        boolean removed = false;
        if (bucket != null) {
            removed = bucket.remove(o);
            if (removed) {
                size--;
                if (bucket.isEmpty()) {
                    table[bucketIndex] = null;
                }
            }
        }
        return removed;
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
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

}
