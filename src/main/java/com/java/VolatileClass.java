package com.java;

public class VolatileClass {
    static volatile boolean istrue=true;
    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(){
            @Override
            public void run() {
                while (istrue){
                    System.out.println("in thread t1: "+Thread.currentThread().getName());
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                istrue=false;
                System.out.printf("in thread t2: "+Thread.currentThread().getName());
            }
        };
        t1.start();
        Thread.sleep(100);
        t2.start();
    }
}

