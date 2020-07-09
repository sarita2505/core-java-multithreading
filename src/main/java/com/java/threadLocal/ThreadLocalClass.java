package com.java.threadLocal;

public class ThreadLocalClass implements Runnable {
    ThreadLocal<Integer> local = new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 0;
        }
    };
  //  int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            //System.out.println(Thread.currentThread().getName());
            local.set(local.get() +1);
            System.out.println(Thread.currentThread().getName()+" "+local.get());
//            count++;
//            System.out.println(Thread.currentThread().getName()+" count :"+ count);
        }
    }
}
