package com.kebo.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 19:33
 **/
public class MyCallable implements Callable<String> {
    private int ticket=50;
    @Override
    public String call() throws Exception {
        for (int x = 0; x < 200; x++) {
            if(ticket>0) {
                System.out.println(Thread.currentThread().getName() + "抢到了一张票");
                ticket--;
            }
        }
        return "票已经卖光";
    }

    public static void main(String[] args) throws Exception{
        MyCallable myCallable1 = new MyCallable();
        MyCallable myCallable2 = new MyCallable();
        FutureTask<String> futureTask1 = new FutureTask<>(myCallable1);
        FutureTask<String> futureTask2 = new FutureTask<>(myCallable2);
        new Thread(futureTask1, "有返回值的线程").start();
        new Thread(futureTask2, "有返回值的线程").start();
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());

    }
}

