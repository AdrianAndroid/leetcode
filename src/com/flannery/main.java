package com.flannery;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        HashMap<String, String> map = new HashMap<>();
        map.put("111", "111");
        map.put("222", "111");
        map.put("333", "111");
        map.put("444", "111");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        System.out.println(Integer.toBinaryString("asdfasdf".hashCode() ^ "asdfasdf".hashCode()>>>16));
        // (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
        // 1101000000101110 0110111001101000
        //                  1101000000101110
        // 1101000000101110 1011111001000110
    }

}
