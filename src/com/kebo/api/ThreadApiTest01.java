package com.kebo.api;

import com.kebo.thread.MyThread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 20:04
 **/
public class ThreadApiTest01 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        System.out.println("线程开始之前"+myThread.isAlive());
        myThread.start();
        System.out.println("线程开始之后"+myThread.isAlive());
    }
}

