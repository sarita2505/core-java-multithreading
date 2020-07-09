package com.java.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class ConsumerClass implements Runnable {
    List<Integer> sharedList = new ArrayList<>();
    Integer max_size = 5;

    public ConsumerClass(List<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
       // synchronized (ConsumerClass.class) {
            for (int i = 0; i < max_size; i++) {
                consume();
            }
       // }
    }

    public void consume() {
        synchronized (sharedList) {
            if (sharedList.isEmpty()) {
                try {
                    System.out.println("thread is empty :" + Thread.currentThread().getName());
                    sharedList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (sharedList) {
            System.out.println("removing element from list: " + Thread.currentThread().getName());
            System.out.println(sharedList.remove(0));
            sharedList.notify();
        }
    }
}
