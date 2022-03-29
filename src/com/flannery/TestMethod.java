package com.flannery;

public class TestMethod extends BaseClass {

    static int a;
    int b;

    public TestMethod() {
        super();
        System.out.println("TestMethod# constructor of exec");
    }

    static {
        String a1 = "12";
        String a2 = "22";
        a = Integer.parseInt(a1) + Integer.parseInt(a2);
        System.out.println("TestMethod# chilren static block");
    }

    {
        String b1 = "12";
        String b2 = "22";
        b = Integer.parseInt(b1) + Integer.parseInt(b2);
        System.out.println("TestMethod@ children normal block");
    }

    public static void main(String[] args) {
        System.out.println("main# TestMethod.a = " + TestMethod.a);
        TestMethod.a = 45;
        new TestMethod();
        System.out.println("main# TestMethod.a = " + TestMethod.a);
        new TestMethod();
        System.out.println("main# TestMethod.a = " + TestMethod.a);
    }

}
