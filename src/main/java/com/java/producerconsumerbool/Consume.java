package com.java.producerconsumerbool;

import java.util.List;

public class Consume implements Runnable{
    private Produce produce;
    List<Integer> sharedList;

    public Consume(Produce produce, List<Integer> sharedList) {
        this.produce = produce;
        this.sharedList = sharedList;
    }

    public Consume(List<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (produce.is_produced){
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer size=produce.sharedList.size();
        for (int i=0;i<size;i++){
            System.out.println("consuming elements :"+sharedList.remove(0));
        }
    }
}
