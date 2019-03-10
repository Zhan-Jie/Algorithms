package com.succsoft.algorithms;

/**
 * @author zj
 *
 * 2017年7月18日
 */
public class TestMyMap {
  public static void main(String[] args) {
    MyMap<String, String> map = new MyMap<>();
    map.put("one", "1");
    map.put("two", "2");
    map.put("three", "3");
    map.put("four", "4");
    map.put("five", "5");
    map.put("six", "6");
    map.put("seven", "7");
    map.put("eight", "8");
    map.put("nine", "9");
    map.put("zero", "0");
    System.out.println("key4:" + map.get("four"));
    System.out.println("key3:" + map.get("three"));
    System.out.println("key2:" + map.get("two"));
    System.out.println("key1:" + map.get("one"));
    System.out.println("key0:" + map.get("zero"));
    System.out.println("key5:" + map.get("five"));
    System.out.println("key6:" + map.get("six"));
    System.out.println("key7:" + map.get("seven"));
    System.out.println("key8:" + map.get("eight"));
    System.out.println("key9:" + map.get("nine"));
    System.out.println("capacity:" + map.capacity());
    System.out.println("size:" + map.size());
  }
}
