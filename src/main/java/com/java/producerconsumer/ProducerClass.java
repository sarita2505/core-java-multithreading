package com.java.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerClass implements Runnable {
    List<Integer> sharedList = new ArrayList<>();

    public ProducerClass(List<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    Integer max_size = 5;

    @Override
    public void run() {
       // synchronized (ProducerClass.class) {
            for (int i = 0; i < max_size; i++) {
                produce(i);
            }
        //}
    }

    public void produce(int i) {

        synchronized (sharedList) {
            if (sharedList.size() == max_size) {
                try {
                    System.out.println("list is full: " + Thread.currentThread().getName());
                    sharedList.wait();
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException :" + e);
                }
            }
        }
        synchronized (sharedList) {
            System.out.println("adding element to list: " + Thread.currentThread().getName());
            //System.out.println(sharedList.add(i));
            sharedList.add(i);
            System.out.println("element added is:"+i);
            sharedList.notify();
        }
    }
}
