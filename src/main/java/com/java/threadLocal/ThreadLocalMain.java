package com.java.threadLocal;

public class ThreadLocalMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocalClass localClass=new ThreadLocalClass();
        Thread t1=new Thread(localClass,"t1");
        Thread t2=new Thread(localClass,"t2");
        t1.start();
        //t1.join();
        t2.start();
        t1.join();
        t2.join();
    }
}
