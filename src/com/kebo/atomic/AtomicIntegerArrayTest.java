package com.kebo.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-06 20:21
 **/
public class AtomicIntegerArrayTest {
    static int[] value = new int[]{1, 2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        new Thread(() -> {
            ai.getAndSet(0, 3);
            //输出3
            System.out.println(ai.get(0));
            //输出1
            System.out.println(value[0]);
        }).start();

    }
}

