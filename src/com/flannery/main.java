package com.flannery;

import java.util.HashSet;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");
        set1.add("4");
        set1.add("5");

        Set<String> set2 = new HashSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("3");

        set1.removeAll(set2);

        System.out.println(set1);

    }

}
