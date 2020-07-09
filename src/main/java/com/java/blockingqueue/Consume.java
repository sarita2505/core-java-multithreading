package com.java.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consume implements Runnable {
    BlockingQueue<Integer> queue;

    public Consume(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("trying to take :"+Thread.currentThread().getName());
                System.out.println("taking elements :"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
