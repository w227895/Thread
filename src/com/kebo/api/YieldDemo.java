package com.kebo.api;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 20:51
 **/
public class YieldDemo {
    public static void main(String[] args) {
        YieldThread yieldThread=new YieldThread();
        Thread thread1=new Thread(yieldThread,"线程A");
        Thread thread2=new Thread(yieldThread,"线程B");
        thread1.start();
        thread2.start();
    }
}
class YieldThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <50 ; i++) {
            System.out.println(Thread.currentThread().getName()+"运行-->"+i);
            if(i==30){
                System.out.println("线程礼让:");
                Thread.currentThread().yield();
            }
        }
    }
}
