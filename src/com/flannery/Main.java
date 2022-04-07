package com.flannery;

import java.util.concurrent.*;

// https://blog.csdn.net/qq_40177006/article/details/113006868
// 问题：
// 只有一个核心线程， 但该核心线程被阻塞
//
// 解决：
// 1.将LinkedBlockingQueue换成有限队列ArrayBlockingQueue（按照测试代码，可以将队列设置容量小于3）
// 2.将核心线程数扩大（只要保证核心线程不全部被阻塞即可）
public class Main {

    private static ThreadPoolExecutor sThreadPool =
            new ThreadPoolExecutor(1, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>(3));

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
                System.out.println(""+countDownLatch.getCount());
                System.out.println("countDown out");
            }
        };

        for (int i = 0; i < 7; i++) {
            execute(countDownRunnable);
        }

        execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("normal");
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        concurrentByDownLatch();
    }

}
