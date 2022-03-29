package com.flannery.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {
}

class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                5,      // coolPoolSize
                10, // maximumPoolSize
                200,   // keepAliveTime
                TimeUnit.MILLISECONDS, // TimeUnit
                new ArrayBlockingQueue<Runnable>(5)  // workQueue
        );
        for (int i = 0; i < 15; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程树目:"+executor.getPoolSize()+",队列中等待执行的任务数目:"+
                    executor.getQueue().size()+"，已执行完别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    private int taskNum;

    MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task " + taskNum + " 执行完毕");
    }
}