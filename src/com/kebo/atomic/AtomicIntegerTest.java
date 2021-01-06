package com.kebo.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-06 20:21
 **/
public class AtomicIntegerTest {
    static AtomicInteger atomicInteger = new AtomicInteger(1);
    static int a = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                atomicInteger.getAndIncrement();
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使用原子类的值:" + atomicInteger.get());

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                a++;
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("不使用原子类的值:" + a);
    }
}

