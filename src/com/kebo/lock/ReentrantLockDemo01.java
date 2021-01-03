package com.kebo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 18:56
 **/
public class ReentrantLockDemo01 {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        //该线程先获取锁1,再获取锁2
        Thread thread1 = new Thread(new ThreadDemo(lock1, lock2));
        //该线程先获取锁2,再获取锁1
        Thread thread2 = new Thread(new ThreadDemo(lock2, lock1));
        thread1.start();
        thread2.start();
        //是第一个线程中断
        thread2.interrupt();
    }

    static class ThreadDemo implements Runnable {
        Lock firstLock;
        Lock secondLock;

        public ThreadDemo(Lock firstLock, Lock secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                firstLock.lockInterruptibly();
                //更好的触发死锁
                TimeUnit.MILLISECONDS.sleep(10);
                secondLock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                firstLock.unlock();
                secondLock.unlock();
                System.out.println(Thread.currentThread().getName() + "正常结束!");
            }
        }
    }
}

