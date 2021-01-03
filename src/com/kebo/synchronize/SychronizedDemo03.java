package com.kebo.synchronize;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 14:26
 **/
public class SychronizedDemo03 implements Runnable {

    static SychronizedDemo03 instance = new SychronizedDemo03();

    static int i = 100;

    @Override
    public void run() {
        synchronized(instance){
            for(int j=0;j<1000;j++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SychronizedDemo03 sychronizedDemo01 = new SychronizedDemo03();
        Thread thread1 = new Thread(sychronizedDemo01);
        Thread thread2 = new Thread(sychronizedDemo01);
        Thread thread3 = new Thread(sychronizedDemo01);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println(SychronizedDemo03.i);
    }
}

