package com.flannery;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //testProductConsumeByWaitAndNotify();
//        testProductConsumeByLock();
        testProductConsumeByBlockingQueue();
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
                while (true) {
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

    public static void testProductConsumeByLock() {
        final int SIZE = 10;
        ReentrantLock lock = new ReentrantLock();
        final Condition full = lock.newCondition();
        final Condition empty = lock.newCondition();
        Queue<String> queue = new ArrayDeque<>(SIZE);

        Runnable producer = new Runnable() {

            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 20; i++) {
                    lock.lock();
                    try {
                        if (queue.size() == SIZE) {
                            try {
                                full.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        String msg = "生产消息:" + i;
                        queue.add(msg);
                        System.out.println(msg);
                        empty.signal();
                    } finally {
                        lock.unlock();
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while (true) {
                    lock.lock();
                    try {
                        if (queue.isEmpty()) {
                            try {
                                empty.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            String msg = queue.remove();
                            System.out.println(msg + "已消费");
                            full.signal();
                        }
                    } finally {
                        lock.unlock();
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

    public static void testProductConsumeByBlockingQueue() {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Runnable producer = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(50);

                        String msg = "消息：" + i;
                        queue.put(msg);
                        System.out.println("放入");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = queue.take();
                        System.out.println("取出 ： " + msg);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
