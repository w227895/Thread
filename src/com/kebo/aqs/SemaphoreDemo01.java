package com.kebo.aqs;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-04 21:00
 **/


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
public class SemaphoreDemo01 {
    public static void main(String[] args) {
        //设置三个车位
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    //获得一个车位
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "溜了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放车位
                    semaphore.release();
                }

            }).start();
        }
    }
}


