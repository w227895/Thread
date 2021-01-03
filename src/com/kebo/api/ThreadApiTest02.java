package com.kebo.api;

import com.kebo.thread.MyThread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 20:04
 **/
public class ThreadApiTest02 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main线程开始执行");
        for (int i = 0; i < 50; i++) {
            if (i > 10) {
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+"在执行");
        }
        System.out.println("main线程结束执行");
    }
}
