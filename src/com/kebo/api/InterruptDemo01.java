package com.kebo.api;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 21:50
 **/
public class InterruptDemo01 {
    public static void main(String[] args) {
        InterruptThread01 interruptThread01=new InterruptThread01();
        Thread thread=new Thread(interruptThread01);
        thread.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //设置线程中断标志位
        thread.interrupt();
    }
}

class InterruptThread01 implements Runnable{

    @Override
    public void run() {
        //判断线程是否需要被中断
       while (!Thread.interrupted()){
           System.out.println("方法正常执行");
       }
        System.out.println("线程结束啦");
    }
}

