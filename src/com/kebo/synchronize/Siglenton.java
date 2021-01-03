package com.kebo.synchronize;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-03 14:49
 **/
public class Siglenton {
    private volatile static Siglenton intance;

    private Siglenton() {
    }

    public static Siglenton getIntance() {
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if (intance == null) {
            //类对象加锁
            synchronized (Siglenton.class) {
                //如果第一个线程进来,实例化了一个对象,那么intance不为空
                //第二个线程进来如果不做校验,又会重新实例化
                if (intance == null) {
                    intance = new Siglenton();
                }
            }
        }
        return intance;
    }
}

