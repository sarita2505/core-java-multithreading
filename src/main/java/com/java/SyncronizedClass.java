package com.java;

public class SyncronizedClass {
    static volatile int i = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread() {
            @Override
            public  void  run() {
                synchronized (SyncronizedClass.class){
                    //while (i < 10) {
                    ++i;
                    System.out.println(Thread.currentThread().getName() + " " + i);}
                    // }
            }
        };
        Thread t2 = new Thread(() -> {
            //while (i < 10) {
            synchronized (SyncronizedClass.class){
                ++i;
                System.out.println(Thread.currentThread().getName() + " " + i);}
            //}
        });
        t1.start();

        t2.start();
    }

}
