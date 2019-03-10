package com.succsoft.algorithms;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author zj
 *
 * 2017年7月18日
 */
public class MyMap<K, V> implements Map<K, V> {
    private int capacity = 8;
    private float factor = 0.8f;
    private int size = 0;

    private MyEntry<K, V>[] entries;

    public MyMap() {
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size < 1;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }



    public V get(Object key) {
        int h = hash(key);
        int index = h & (capacity-1);

        MyEntry<K, V> e = entries[index];
        while (e != null) {
            if (e.key.equals(key)) {
                return e.value;
            }
            e = e.next;
        }
        return null;
    }

    @SuppressWarnings({"unchecked"})
    private void expand() {
        if (entries == null) {
            entries = new MyEntry[capacity];
            return;
        }
        capacity = capacity << 1;
        MyEntry<K, V>[] newEntries = (MyEntry<K, V>[]) new MyEntry[capacity];

        // redistribute original elements on new array
        for (MyEntry<K, V> e : entries) {
            if (e == null) {
                continue;
            }
            newEntries[e.hash & (capacity - 1)] = e;
        }

        entries = newEntries;
    }

    public V put(K key, V value) {
        if (((int)(factor*capacity)) <= size || entries == null)
            expand();
        MyEntry<K, V> e = new MyEntry<>(key, value);
        int index = e.hash & (capacity-1);
        System.out.printf("entries[%d] = %s%n", index, value);
        if (entries[index] == null) {
            entries[index] = new MyEntry<>(key, value);
            ++size;
        } else {
            MyEntry<K, V> oldEntry = entries[index];
            entries[index] = e;
            e.next = oldEntry;
            ++size;
        }
        return value;
    }

    public V remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

    }

    public void clear() {

    }

    private Set<K> cachedKeySet;

    public Set<K> keySet() {
        return null;
    }

    private int hash(Object key) {
        if (key != null) {
            int h = key.hashCode();
            return h ^ (h >>> 16);
        } else {
            return 0;
        }
    }

    public Collection<V> values() {
        return null;
    }
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

    private class MyEntry<EK, EV> implements Entry<EK, EV> {
        private EK key;
        private EV value;
        private int hash;
        private MyEntry<EK, EV> next;

        MyEntry(EK key, EV value) {
            this.key = key;
            this.value = value;
            this.hash = hash(key);
        }

        public EK getKey() {
            return this.key;
        }

        public EV getValue() {
            return value;
        }

        public EV setValue(EV value) {
            return this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MyEntry))
                return false;
            @SuppressWarnings({"unchecked"})
            MyEntry<EK, EV> e = (MyEntry<EK, EV>)o;
            if (key != null) {
                return key.equals(e.key);
            } else {
                return e.key == null;
            }
        }
    }
}
