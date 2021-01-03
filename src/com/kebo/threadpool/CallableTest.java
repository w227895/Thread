package com.kebo.threadpool;

import java.util.concurrent.*;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 21:33
 **/
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            String a = "test Executor";
            return a;
        } catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }

    }

    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5, 10,
                100, MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
        Future<String> future = tpe.submit(new CallableTest());
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            tpe.shutdown();
        }
    }
}

