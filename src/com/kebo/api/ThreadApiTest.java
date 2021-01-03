package com.kebo.api;

import com.kebo.thread.MyThread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 19:57
 **/
public class ThreadApiTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread=new MyThread();
        myThread.start();
        myThread.setName("myThread");
        System.out.println(myThread.getName());
    }
}

