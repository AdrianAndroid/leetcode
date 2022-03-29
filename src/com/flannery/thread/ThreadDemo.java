package com.flannery.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;

    public ThreadDemo(String threadName) {
        this.threadName = threadName;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        //super.run();

    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}


class CallableThreadTest implements Callable<Integer> {

    public static void main(String[] args) {
        CallableThreadTest ctt = new CallableThreadTest();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " 的循环变量i的值 " + i);
            if(i == 20) {
                new Thread(ft, "有返回值的线程").start();
            }
        }
        try {
            System.out.println("子线程的返回值："+ft.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int i;
        for (i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return i;
    }
}

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + " , " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();
        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();
    }
}
