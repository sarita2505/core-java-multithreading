package com.java.latch;

import java.util.concurrent.CountDownLatch;

public class CdlMain {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread started");
        CountDownLatch latch=new CountDownLatch(3);
        Thread t1=new Thread(new CdlClass("sari",latch));
        Thread t2=new Thread(new CdlClass("rita",latch));
        Thread t3=new Thread(new CdlClass("sarita",latch));
        t1.start();
        t2.start();
        t3.start();
        latch.await();
        System.out.println("main thread is terminated");
    }
}
