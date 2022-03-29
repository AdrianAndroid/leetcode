package com.flannery;

public class BaseClass {

    static int a;
    int b;

    static {
        String a1 = "10";
        String a2 = "20";
        a = Integer.parseInt(a1) + Integer.parseInt(a2);
        System.out.println("BaseClass# baseClass static block");
        System.out.println("BaseClass# a = " + a);
    }

    {
        String b1 = "10";
        String b2 = "20";
        b = Integer.parseInt(b1) + Integer.parseInt(b2);
        System.out.println("BaseClass# baseClass normal block");
        System.out.println("BaseClass# b = " + b);
    }

    public BaseClass() {
        System.out.println("BaseClass# Base class constructor of exec");
        System.out.println("BaseClass# BaseClass.a = " + BaseClass.a);
        BaseClass.a = 300;
        System.out.println("BaseClass# BaseClass.a = " + BaseClass.a);
    }

}
