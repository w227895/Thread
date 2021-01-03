package com.kebo.api;

import com.kebo.thread.MyThread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 20:59
 **/
public class PriorityDemo {
    public static void main(String[] args) {
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();
        MyThread myThread3=new MyThread();
        //10
        myThread1.setPriority(Thread.MAX_PRIORITY);
        //5
        myThread3.setPriority(Thread.NORM_PRIORITY);
        //1
        myThread2.setPriority(Thread.MIN_PRIORITY);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        //主线程的优先级是5
        System.out.println(Thread.currentThread().getPriority());
    }
}

