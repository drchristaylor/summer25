package wk8;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class BST implements Set<String> {

    private class Node {
        String value;
        Node lKid;
        Node rKid;

        Node(String value) {
            this.value = value;
        }
    }

    private Node root;

    public BST() {
        root = null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object target) {
        return target instanceof String && contains(root, (String) target);
    }

    private boolean contains(Node subroot, String target) {
        if (subroot == null) {
            return false;
        }
        if (subroot.value.equals(target)) {
            return true;
        } else if (subroot.value.compareTo(target) > 0) {
            return contains(subroot.lKid, target);
        } else {
            return contains(subroot.rKid, target);
        }
    }

    @Override
    public boolean add(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Tree does not support nulls");
        }
        boolean added = false;
        if (root == null) {
            root = new Node(s);
            added = true;
        } else {
            added = add(root, s);
        }
        return added;
    }

    private boolean add(Node subroot, String s) {
        boolean added = false;
        int compareResult = s.compareTo(subroot.value);
        if (compareResult < 0) {
            if (subroot.lKid == null) {
                subroot.lKid = new Node(s);
                added = true;
            } else {
                added = add(subroot.lKid, s);
            }
        } else if (compareResult > 0) {
            if (subroot.rKid == null) {
                subroot.rKid = new Node(s);
                added = true;
            } else {
                added = add(subroot.rKid, s);
            }
        }
        return added;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node subroot) {
        return subroot == null ? 0 : 1 + size(subroot.lKid) + size(subroot.rKid);
    }

    public int height() {
        return height(root);
    }

    private int height(Node subroot) {
        return subroot == null ? 0 : 1 + Math.max(height(subroot.lKid), height(subroot.rKid));
    }

    @Override
    public Iterator<String> iterator() {
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
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
    public void clear() {

    }
}