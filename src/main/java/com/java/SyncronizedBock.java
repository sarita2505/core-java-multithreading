package com.java;

public class SyncronizedBock {
    public static void main(String[] args) {
//        Runnable runnable=new Thread1();
//        Thread t1=new Thread(runnable,"t1");
//        Thread t2=new Thread(runnable,"t2");
//        t1.start();
//        t2.start();
        Runnable runnable = new Thread2();
        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();
        Runnable runnable1 = new Thread2();
        Thread t3 = new Thread(runnable1, "t3");
        t3.start();
    }
}

class Thread1 implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }

    }
}

class Thread2 implements Runnable {
    @Override
    public void run() {
        m1();
    }

    public synchronized void m1() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}