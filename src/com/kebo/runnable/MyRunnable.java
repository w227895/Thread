package com.kebo.runnable;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 19:23
 **/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x < 200; x++) {
            System.out.println(Thread.currentThread().getName()+"->"+x);
        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable=new MyRunnable();
        Thread thread1=new Thread(myRunnable);
        Thread thread2=new Thread(myRunnable);
        thread1.start();
        thread2.start();

    }
}

