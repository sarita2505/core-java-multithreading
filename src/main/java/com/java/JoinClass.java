package com.java;

public class JoinClass {
    public static void main(String[] args) {

        System.out.println("inside main thread");
        Thread t1=new Thread(()->{
            for (int i=0;i<5;i++){
            System.out.println("inside the run() of t1: " +Thread.currentThread().getName());
            m1();}
        });
        Thread t2=new Thread(()->{
            for (int i=0;i<5;i++){
            System.out.println("inside the run() of t2: "+Thread.currentThread().getName());
            m2();}
        });
        t1.start();
        try {
            t1.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread ended");
    }
    public static void m1(){
        System.out.println("in method 1");
    }
    public static void m2(){
        System.out.println("in method 2");
    }
}
