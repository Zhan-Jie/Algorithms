package com.succsoft.algorithms;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author zj
 *
 * 2017年7月18日
 */
public class MyMap<K, V> implements Map<K, V> {
  private int capacity = 10;
  private float factor = 0.8f;
  private int size = 0;
  private int slotsUsed = 0;
  
  private Slot<K, V>[] entries; 
  
  public MyMap() {
    entries = new Slot[capacity];
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
    int index = calcIndex(key);
    if (entries[index] == null) {
      return null;
    } else {
      MyEntry<K, V> entry = entries[index].get(key);
      return entry == null ? null : entry.getValue();
    }
  }

  private void expand() {
    Slot<K, V>[] slots = new Slot[this.capacity*2];
    System.arraycopy(entries, 0, slots, 0, capacity);
    capacity = slots.length;
    entries = slots;
  }
  
  public V put(K key, V value) {
    if (Math.round((factor*capacity)) <= slotsUsed)
      expand();
    MyEntry<K, V> entry = new MyEntry<K, V>(key, value);
    int index = calcIndex(key);
    if (entries[index] == null) {
      entries[index] = new Slot<K, V>(1);
      entries[index].add(entry);
      ++size;
      ++slotsUsed;
    } else {
      if (entries[index].put(entry))
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

  public Collection<V> values() {
    return null;
  }
  public Set<Entry<K, V>> entrySet() {
    return null;
  }

  private int calcIndex(Object key) {
    return (capacity - 1) & hash(key);
  }
  
  private int hash(Object key) {
    int h;
    return key == null ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }
  
  private class Slot<K, V> {
    private int size = 0;
    private Object[] list;
    
    public Slot(int capacity) {
      list = new Object[capacity];
    }
    
    public int size() {
      return size;
    }
    
    public int capacity() {
      return list.length;
    }
    
    public MyEntry<K, V> get(Object key) {
      for (int i = 0; i < size; ++i) {
        MyEntry<K, V> entry = (MyEntry<K, V>)list[i];
        if (Objects.equals(key, entry.getKey()))
          return entry;
      }
      return null;
    }
    
    /**
     * 
     * @param entry
     * @return true when a new entry is inserted,
     *  false when an entry is updated. 
     */
    public boolean put(MyEntry<K, V> entry) {
      for (int i = 0; i < list.length; ++i) {
        if (entry.equals(list[i])) {
          list[i] = entry;
          return false;
        }
      }
      add(entry);
      return true;
    }
    
    public void add(MyEntry<K, V> entry) {
      if (size >= list.length) {
        list = resizeArray(list, list.length*2);
      }
      list[size++] = entry;
    }
    
    private Object[] resizeArray(Object[] arr, int newSize) {
      Object[] newArray = new Object[newSize];
      System.arraycopy(arr, 0, newArray, 0, arr.length);
      return newArray;
    }
  }
  
  private class MyEntry<K, V> implements Entry<K, V> {
    private K key;
    private V value;
    
    public MyEntry(K key, V value) {
      this.key = key;
      this.value = value;
    }
    
    public K getKey() {
      return this.key;
    }

    public V getValue() {
      return value;
    }

    public V setValue(V value) {
      return this.value = value;
    }
    
    @Override
    public boolean equals(Object o) {
      if (o == null || !(o instanceof MyEntry))
        return false;
      MyEntry<K, V> e = (MyEntry<K, V>)o;
      if (key != null) {
        return key.equals(e.key);
      } else {
        return e.key == null;
      }
    }
  }
}
