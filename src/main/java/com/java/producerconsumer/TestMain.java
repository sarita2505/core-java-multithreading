package com.java.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Runnable producerClass=new ProducerClass(list);
        Runnable consumerClass=new ConsumerClass(list);
        Thread t1=new Thread(producerClass,"t1");
        Thread t2=new Thread(consumerClass,"t2");
        t2.start();
        t1.start();
    }
}
