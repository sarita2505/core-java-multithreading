package com.java;

public class JoinExample {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("inside the main thread");
        Runnable runnable=new MyRunnable();
        Thread t1=new Thread(runnable,"t1");
        Thread t2=new Thread(runnable,"t2");
        t1.start();
        t1.join(1500);
        t2.start();
        t2.join();
        System.out.println("main thread ended");
    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+" "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}