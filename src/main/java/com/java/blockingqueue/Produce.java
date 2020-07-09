package com.java.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Produce implements Runnable {
    BlockingQueue<Integer> queue;

    public Produce(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("produced :" + Thread.currentThread().getName() + " " + i);
            queue.add(i);
        }
    }
}
