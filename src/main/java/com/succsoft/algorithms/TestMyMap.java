package com.succsoft.algorithms;

import java.util.Random;

/**
 * @author zj
 *
 * 2017年7月18日
 */
public class TestMyMap {
    public static void main(String[] args) {
        MyMap<String, String> map = new MyMap<>();
        map.put("316d", "1");
        map.put("e9bc", "2");
        map.put("85d0", "3");
        map.put("4d79", "4");
        map.put("9909", "5");
        map.put("b1c2", "6");
        map.put("bfc4", "7");
        System.out.println("1 -> " + map.get("316d"));
        System.out.println("2 -> " + map.get("e9bc"));
        System.out.println("3 -> " + map.get("85d0"));
        System.out.println("4 -> " + map.get("4d79"));
        System.out.println("5 -> " + map.get("9909"));
        System.out.println("6 -> " + map.get("b1c2"));
        System.out.println("7 -> " + map.get("bfc4"));
        System.out.println("capacity:" + map.capacity());
        System.out.println("size:" + map.size());
    }

    /**
     * 找出会在HashMap的表格中产生冲突的字符串
     */
    private static void findString() {
        String s = randomStr();
        System.out.println(s);
        final int index = index(s);
        for (int i = 0; i < 6;) {
            s = randomStr();
            if (index == index(s)) {
                System.out.println(s);
                ++i;
            }
        }
    }

    private static int index(String str) {
        int h = str.hashCode();
        return ((h >>> 16) ^ h) & 7;
    }

    private static String randomStr() {
        Random r = new Random();
        char[] dict = "abcdef0123456789".toCharArray();
        char[] str = new char[4];
        for (int i = 0; i < str.length; ++i) {
            str[i] = dict[r.nextInt(dict.length)];
        }
        return new String(str);
    }
}
