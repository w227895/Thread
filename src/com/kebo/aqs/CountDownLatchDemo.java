package com.kebo.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-04 21:24
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "go out");
                //数量减1
                countDownLatch.countDown();
            }).start();
        }
        try {
            //等待计算器归0,否则一直阻塞
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //一定在最后执行
        System.out.println("Close Door");
    }
}

