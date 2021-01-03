package com.kebo.api;

import com.kebo.thread.MyThread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 20:04
 **/
public class ThreadApiTest03 {
    public static void main(String[] args) {
        System.out.println("main线程开始执行");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main线程结束执行");
    }
}
