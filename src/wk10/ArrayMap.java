package wk10;

import java.util.*;

public class ArrayMap<K, V> implements Map<K, V> {
    private ArrayList<Map.Entry<K, V>> list;

    public ArrayMap() {
        list = new ArrayList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        boolean found = false;
        for (int i = 0; !found && i < list.size(); i++) {
            found = Objects.equals(key, list.get(i).getKey());
        }
        return found;
    }

    @Override
    public boolean containsValue(Object value) {
        boolean found = false;
        for (int i = 0; !found && i < list.size(); i++) {
            found = Objects.equals(value, list.get(i).getValue());
        }
        return found;
    }

    @Override
    public V get(Object key) {
        boolean found = false;
        int index = 0;
        while (!found && index < list.size()) {
            found = Objects.equals(key, list.get(index++).getKey());
        }
        return found ? list.get(index - 1).getValue() : null;
    }

    @Override
    public V put(K key, V value) {
        V retVal = null;
        int index = 0;
        while (retVal == null && index < list.size()) {
            if (Objects.equals(key, list.get(index++).getKey())) {
                retVal = list.get(index - 1).getValue();
                list.get(index - 1).setValue(value);
            }
        }
        if (retVal == null) {
           list.add(Map.entry(key, value));
        }
        return retVal;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return Set.of();
    }

    @Override
    public Collection<V> values() {
        return List.of();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return Set.of();
    }
}
