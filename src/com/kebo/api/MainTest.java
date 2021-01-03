package com.kebo.api;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 21:36
 **/
import java.time.LocalTime;

public class MainTest {

    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start " + LocalTime.now());
        Thread thread = new Thread(new MyThread());
        thread.start();

        Thread thread2 = new Thread(new MyThread());
        thread2.start();

        System.out.println("Main sleep 5s " + LocalTime.now());
        Thread.sleep(5000);
        System.out.println("Main try to get lock... " + LocalTime.now());
        synchronized(lock){
            System.out.println("Main get lock and notifyAll " + LocalTime.now());
            lock.notifyAll();
        }

        System.out.println("Main end");
    }

    public static class MyThread implements Runnable{

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " run and try to get lock... " + LocalTime.now());
            synchronized (lock){
                System.out.println(threadName + " get lock and sleep 2s... " + LocalTime.now());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + " wait " + LocalTime.now());
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(threadName + " get lock agein and sleep 2s " + LocalTime.now());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " end " + LocalTime.now());
        }
    }
}
