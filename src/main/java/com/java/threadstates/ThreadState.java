package com.java.threadstates;

public class ThreadState {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread started");
        Runnable t1 = new PrintThreadState();
        Thread thread = new Thread(t1, "t1");
        System.out.println("before starting thread :" + thread.getState());
        thread.start();
        System.out.println("after starting thread :" + thread.getState());
        // Thread.sleep(1000);
        //System.out.println("after sleeping for some time: "+thread.getState());
      //  thread.join(2000);
        Thread.sleep(2000);
      //  System.out.println(thread.getState());
        System.out.println("after join :" + thread.getState());

        synchronized (t1)
        {
            t1.notify();
        }
        System.out.println(thread.getState());
        Thread.sleep(3000);
        System.out.println(thread.getState());


    }

}

class PrintThreadState implements Runnable {

    @Override
    public void run() {
        synchronized (this)
        {
            try {
                System.out.println(System.currentTimeMillis());
                this.wait();
                System.out.println("waiting: "+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getState());
    }
}
