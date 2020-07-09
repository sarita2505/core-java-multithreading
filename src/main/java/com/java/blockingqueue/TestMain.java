package com.java.blockingqueue;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class TestMain {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue=new LinkedBlockingDeque<>();
        Runnable produce=new Produce(queue);
        Runnable consume=new Consume(queue);
        Thread t1=new Thread(produce,"t1");
        Thread t2=new Thread(consume,"t2");
        t1.start();
        t2.start();
    }
}
