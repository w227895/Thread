package com.kebo.threalocal;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-05 19:43
 **/
public class MyDemo02 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo02 myDemo01 = new MyDemo02();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (MyDemo02.class) {
                    myDemo01.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("------------------------------");
                    System.out.println(Thread.currentThread().getName() + "----->" + myDemo01.getContent());
                }
            }).start();
        }
    }
}

