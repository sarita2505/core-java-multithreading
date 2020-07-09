package com.java.producerconsumerbool;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Runnable produce=new Produce(list);
        Runnable consume=new Consume((Produce) produce,list);
        Thread t1=new Thread(produce,"t1");
        Thread t2=new Thread(consume,"t2");
        t1.start();
        t2.start();

    }
}
