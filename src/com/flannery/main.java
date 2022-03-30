package com.flannery;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        HashMap<String, String> map = new HashMap<>();
        map.put("", "");
        System.out.println(Integer.toBinaryString("asdfasdf".hashCode() ^ "asdfasdf".hashCode()>>>16));
        // (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)
        // 1101000000101110 0110111001101000
        //                  1101000000101110
        // 1101000000101110 1011111001000110
    }

}
