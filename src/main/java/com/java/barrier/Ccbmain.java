package com.java.barrier;

import java.util.concurrent.CyclicBarrier;

public class Ccbmain {
    public static void main(String[] args) {
        System.out.println("main thread satrted");
        CyclicBarrier barrier = new CyclicBarrier(3);
        Thread t1 = new Thread(new CcbClass("sari", barrier), "t1");
        Thread t2 = new Thread(new CcbClass("rita", barrier), "t2");
        Thread t3 = new Thread(new CcbClass("sarita", barrier), "t3");
        t1.start();
        t2.start();
        t3.start();
        System.out.println("main thread ended");
    }
}
