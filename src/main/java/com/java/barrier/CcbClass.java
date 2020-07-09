package com.java.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CcbClass implements Runnable{
    private String name;
    private CyclicBarrier barrier;

    public CcbClass(String name, CyclicBarrier barrier) {
        this.name = name;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            System.out.println("thread is interrupted");
        }
        try {
            System.out.println(Thread.currentThread().getName()+ "calling wait");
            barrier.await();
            System.out.println(Thread.currentThread().getName()+" waiting for other thread completed");
        } catch (InterruptedException e) {
            System.out.println("thread is interupted");
        } catch (BrokenBarrierException e) {
            System.out.println("barrier is broken");
        }
    }
}
