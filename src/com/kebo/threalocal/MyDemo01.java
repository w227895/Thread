package com.kebo.threalocal;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-05 19:43
 **/
public class MyDemo01 {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        MyDemo01 myDemo01 = new MyDemo01();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myDemo01.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("------------------------------");
                System.out.println(Thread.currentThread().getName() + "----->" + myDemo01.getContent());
            }).start();
        }
    }
}

