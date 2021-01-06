package com.kebo.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-06 21:08
 **/
public class AtomicIntegerFieldUpdaterTest {

    //创建原子更新器
    private static AtomicIntegerFieldUpdater<User> updater = AtomicIntegerFieldUpdater.newUpdater(User.class,"age");

    public static void main(String[] args){
        User user = new User("ketty",21);
        //ketty长了一岁
        updater.getAndIncrement(user);
        System.out.println(updater.get(user));
    }

    static class User{

        private String name;
        public volatile int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}

