package com.kebo.lock;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 19:14
 **/
public class LockWriteTask implements Runnable{
    private Foo source;

    public LockWriteTask(Foo source){
        this.source = source;
    }

    @Override
    public void run() {
        source.wirte();
    }
}

