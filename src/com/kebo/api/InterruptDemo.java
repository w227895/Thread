package com.kebo.api;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-02 21:50
 **/
public class InterruptDemo {
    public static void main(String[] args) {
        InterruptThread interruptThread=new InterruptThread();
        Thread thread=new Thread(interruptThread);
        thread.start();
        thread.interrupt();
    }
}
class InterruptThread implements Runnable{

    @Override
    public void run() {
        System.out.println("1.进入run方法");
        try {
            Thread.sleep(2000);
            System.out.println("2.已经完成休眠");
        } catch (InterruptedException e) {
            System.out.println("3.休眠被终止");
            e.printStackTrace();
            return;
        }
        System.out.println("4.run方法正常结束");
    }
}

