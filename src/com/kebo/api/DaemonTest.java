package com.kebo.api;

import com.kebo.thread.MyThread;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 20:43
 **/
public class DaemonTest {
    public static void main(String[] args) {
        MyDamonThread myThread=new MyDamonThread();
        Thread thread=new Thread(myThread);
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class MyDamonThread implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName()+"在运行");
        }
    }
}

