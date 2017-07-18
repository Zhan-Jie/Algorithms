package com.succsoft.algorithms;

/**
 * @author zj
 *
 * 2017年7月18日
 */
public class TestMyMap {
  public static void main(String[] args) {
    MyMap<String, String> map = new MyMap<>();
    map.put("1", "one");
    map.put("2", "two");
    map.put("3", "three");
    map.put("4", "four");
    map.put("5", "five");
    map.put("6", "six");
    map.put("7", "seven");
    map.put("8", "eight");
    map.put("9", "nine");
    map.put("0", "zero");
    System.out.println("key4:" + map.get("4"));
    System.out.println("key3:" + map.get("3"));
    System.out.println("key2:" + map.get("2"));
    System.out.println("key1:" + map.get("1"));
    System.out.println("key0:" + map.get("0"));
    System.out.println("key5:" + map.get("5"));
    System.out.println("key6:" + map.get("6"));
    System.out.println("key7:" + map.get("7"));
    System.out.println("key8:" + map.get("8"));
    System.out.println("key9:" + map.get("9"));
    System.out.println("capacity:" + map.capacity());
    System.out.println("size:" + map.size());
  }
}
