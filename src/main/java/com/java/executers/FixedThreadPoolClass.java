package com.java.executers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolClass {
    public static void main(String[] args) {
        //new FixedThreadPoolClass().normalExecuionOfTasks();
        //new FixedThreadPoolClass().executionOfTasksByFixedThreads();
        //new FixedThreadPoolClass().executionOfTasksByCachedThreads();
       // new FixedThreadPoolClass().executionOfTasksBySingleThread();
        new FixedThreadPoolClass().executionOfTasksByScheduledThreads();
    }
    public void executionOfTasksByScheduledThreads() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 100; i++) {
            //service.schedule(new ThreadpollFixed(),10, TimeUnit.SECONDS);
            service.scheduleAtFixedRate(new ThreadpollFixed(),1,10,TimeUnit.SECONDS);
           // service.scheduleWithFixedDelay(new ThreadpollFixed(),1,10,TimeUnit.SECONDS);
        }
    }
    public void executionOfTasksBySingleThread() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            service.execute(new ThreadpollFixed());
        }
    }

    public void executionOfTasksByCachedThreads() {
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new ThreadpollFixed());
        }
    }


    public void executionOfTasksByFixedThreads() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            service.execute(new ThreadpollFixed());
        }
    }

    public void normalExecuionOfTasks() {
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new ThreadpollFixed());
            t1.start();
        }
    }
}

class ThreadpollFixed implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
