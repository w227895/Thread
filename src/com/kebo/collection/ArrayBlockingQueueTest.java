package com.kebo.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-07 20:14
 **/
public class ArrayBlockingQueueTest {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(5);
        blockingQueue.put("hello1");
        blockingQueue.put("hello2");
        blockingQueue.put("hello3");
        blockingQueue.put("hello4");
        blockingQueue.put("hello5");
        for (int i = 0; i <5 ; i++) {
            new Thread(() -> {
                try {

                    System.out.println(blockingQueue);
                    //获取当前元素
                    System.out.println(blockingQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

