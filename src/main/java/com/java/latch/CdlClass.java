package com.java.latch;

import java.util.concurrent.CountDownLatch;

public class CdlClass implements Runnable{
    private String name;
    private CountDownLatch latch;

    public CdlClass(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("thread execution started: "+Thread.currentThread().getName());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            System.out.println("thread execution interrupted");
        }
        System.out.println("thread is up for running");
        System.out.println("current count is: "+latch.getCount());
        latch.countDown();

    }
}
