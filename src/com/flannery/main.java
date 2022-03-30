package com.flannery;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // 修饰实例方法
    public synchronized void increase1() {
        //i++;
    }

    // 修饰静态方法
    public static synchronized void increase2() {
        //i++;
    }

    // 修饰代码块
    public void synMethod(Object a1) {
        synchronized (a1) { // 需要一个实例

        }
    }
}
