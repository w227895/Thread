package com.kebo.thread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 19:20
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int x = 0; x < 200; x++) {
            System.out.println(Thread.currentThread().getName()+"->"+x);
        }
    }

    public static void main(String[] args) {
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();
        myThread1.start();
        myThread2.start();
    }
}

