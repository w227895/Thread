package com.kebo.threalocal;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-05 19:51
 **/
public class MyDemo {
    ThreadLocal<String> tl = new ThreadLocal<>();
    private String content;

    public String getContent() {
        return tl.get();
    }

    public void setContent(String content) {
        tl.set(content);
    }

    public static void main(String[] args) {
        MyDemo myDemo = new MyDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myDemo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("------------------------------");
                System.out.println(Thread.currentThread().getName() + "----->" + myDemo.getContent());
            }).start();
        }
    }
}

