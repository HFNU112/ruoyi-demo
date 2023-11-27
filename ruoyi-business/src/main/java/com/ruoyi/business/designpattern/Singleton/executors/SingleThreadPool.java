package com.ruoyi.business.designpattern.Singleton.executors;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: shunpeng.hu
 * @date: 2023/11/27 10:53
 */
public class SingleThreadPool {

    public static void main(String[] args) throws InterruptedException {
        // 单线程缓存池
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//        for (int i = 0; i < 10; i++) {
//            final int taskId = i;
//            executorService.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "-> taskId: " + taskId);
//                }
//            });
//            Thread.sleep(1000);
//        }
//        executorService.shutdown();

        // 带缓存的线程池
//        ExecutorService executorService1 = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            final int taskId = i;
//            executorService1.execute(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        System.out.println(Thread.currentThread().getName() + "-> taskId: " + taskId);
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }
//        executorService1.shutdown();

        // 固定线程数量可重用线程池
//        ExecutorService executorService2 = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            final int taskId = 1;
//            executorService2.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "-> taskId: " + taskId);
//                }
//            });
//        }
//        executorService2.shutdown();

        // 定时线程池
        ScheduledExecutorService executorService3 = Executors.newScheduledThreadPool(2);
        executorService3.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(Thread.currentThread().getName() + "-> date: " + date);
            }
        }, 500, 1000, TimeUnit.MILLISECONDS);

        Thread.sleep(5000);
        executorService3.shutdown();
    }

}
