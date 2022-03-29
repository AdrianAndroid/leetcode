package com.flannery;

import java.util.ArrayDeque;
import java.util.Queue;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        testProductConsumeByWaitAndNotify();
    }

    // 1. 使用wait()和notify()实现
    public static void testProductConsumeByWaitAndNotify() {
        final int SIZE = 10;
        // 需要一个队列
        Queue<String> queue = new ArrayDeque<>(SIZE);
        // 需要一个锁
        Object lock = new Object();
        // 生产者
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    try {
                        Thread.sleep(100); // 生产的慢一点
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        while (queue.size() == SIZE) { // 生产的货物满了
                            //暂停生产
                            try {
                                System.out.println("producer : lock.wait()");
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        String msg = "消息：" + i;
                        queue.offer(msg);
                        System.out.println("添加数据：" + msg);
                        lock.notifyAll(); // 通知消费者
                    }
                }
            }
        };

        // 消费者
        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    synchronized (lock) {
                        while (queue.size() == 0) { // 没有数据了
                            try {
                                System.out.println("consumer : lock.wait()");
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        String msg = queue.poll();
                        System.out.println("取出:" + msg);
                        lock.notifyAll();// 通知生产者
                    }
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }
}
