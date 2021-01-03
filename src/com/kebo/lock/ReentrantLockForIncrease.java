package com.kebo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 18:28
 **/
public class ReentrantLockForIncrease {
    //初始化ReentrantLock
    public static ReentrantLock reentrantLock = new ReentrantLock();
    static int count = 0;
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //加锁
                reentrantLock.lock();
                try {
                    int n = 10000;
                    while (n > 0) {
                        count++;
                        n--;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    //执行完毕后释放锁
                    reentrantLock.unlock();
                }
            }
        };
        Thread t1  = new Thread(r);
        Thread t2  = new Thread(r);
        Thread t3  = new Thread(r);
        Thread t4  = new Thread(r);
        Thread t5  = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            //等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}

