package com.kebo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 19:13
 **/
public class Foo {

    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    private final Lock r = rwl.readLock();

    private final Lock w = rwl.writeLock();

    // 读锁，允许同时N个线程进行读操作，不存在竞争
    public void read() {
        r.lock();
        try {
            Thread.sleep(10000);
            System.out.println(Thread.currentThread().getName() + " 正在读...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            r.unlock();
        }

    }

    //写锁，同时允许一个线程写，明显能看到互斥等待
    public void wirte() {
        w.lock();
        try {
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " 正在写...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            w.unlock();
        }
    }

    public static void main(String[] args) {
        //定义共享数据源
        Foo source = new Foo();

        //开启2个写线程:能明显看到t1,t2写线程之间的互斥等待
        Thread t1 = new Thread(new LockWriteTask(source));
        t1.setName("write-Thread-1");
        Thread t2 = new Thread(new LockWriteTask(source));
        t2.setName("write-Thread-2");
        t1.start();
        t2.start();

        //开启5个读线程：读锁，允许同时N个线程进行操作，可以看到读打印操作同时秒出
        Thread rt1 = new Thread(new LockReadTask(source));
        rt1.setName("read-Thread-1");
        Thread rt2 = new Thread(new LockReadTask(source));
        rt2.setName("read-Thread-2");
        Thread rt3 = new Thread(new LockReadTask(source));
        rt3.setName("read-Thread-3");
        Thread rt4 = new Thread(new LockReadTask(source));
        rt4.setName("read-Thread-4");

        rt1.start();
        rt2.start();
        rt3.start();
        rt4.start();
    }
}
