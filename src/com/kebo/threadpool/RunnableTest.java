package com.kebo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 21:39
 **/
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread().getName()+"say Hello");
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10,
                100, MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        try {
            tpe.execute(new RunnableTest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tpe.shutdown();
        }
    }
}

