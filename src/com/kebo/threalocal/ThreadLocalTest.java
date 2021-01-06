package com.kebo.threalocal;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @description:
 * @Author: kb
 * @Date: 2021-01-05 09:59
 */
public class ThreadLocalTest {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                String data = new ThreadLocalTest().date(finalI);
                System.out.println(data);
            }).start();
            Thread.sleep(100);
        }

    }

    private String date(int seconds){
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        return simpleDateFormat.format(date);
    }
}
