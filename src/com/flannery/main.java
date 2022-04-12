package com.flannery;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        ThreadLocal<String> t1 = new ThreadLocal<>();
        t1.set("Hello");

        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("tttt "+t1.get());
                t1.set("World");
                System.out.println("tttt "+t1.get());
            }
        }.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("xxxx "+t1.get());
    }

}
