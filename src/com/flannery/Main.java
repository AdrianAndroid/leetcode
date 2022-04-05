package com.flannery;

import java.util.concurrent.*;

// https://blog.csdn.net/qq_40177006/article/details/113006868
public class Main {

    private static ThreadPoolExecutor sThreadPool =
            new ThreadPoolExecutor(1, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());

    private static void execute(Runnable runnable) {
        try {
            sThreadPool.execute(runnable);
        } catch (RejectedExecutionException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void concurrentByDownLatch() {
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("await in");
                    countDownLatch.await();
                    System.out.println("await out");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Runnable countDownRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("countDown in");
                countDownLatch.countDown();
                System.out.println("countDown out");
            }
        };

        for (int i = 0; i < 3; i++) {
            execute(countDownRunnable);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        concurrentByDownLatch();
    }

}
