package com.flannery;


public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //testList();
        Queue<String> queue = new LinkedList<>();
    }

    private static void testList() {
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add(3, "13");
        list.add( "3");

        printLinkedList(list);
        System.out.println(list.contains("3"));
        list.remove("3");
        printLinkedList(list);
        System.out.println(list.indexOf("3"));
        System.out.println(list.remove(5));
    }

    private static void printLinkedList(Object obj) {
        System.out.println("----------");
        if (obj instanceof LinkedList<?>) {
            for (int i = 0; i < ((LinkedList<?>) obj).size; i++) {
                System.out.println("i=" + i + " \t V=" + ((LinkedList<?>) obj).get(i));
            }
        }
    }
}
