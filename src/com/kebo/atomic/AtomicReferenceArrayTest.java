package com.kebo.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description:
 * @author: kb
 * @create: 2021-01-06 20:21
 **/
public class AtomicReferenceArrayTest {
    private static AtomicReference<User> reference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("tom", 23);
        reference.set(user);
        User updateUser = new User("ketty", 34);
        reference.compareAndSet(user, updateUser);
        System.out.println(reference.get().getName());
        System.out.println(reference.get().getAge());

    }

    static class User {

        private String name;
        private int age;

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

