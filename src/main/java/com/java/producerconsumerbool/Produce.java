package com.java.producerconsumerbool;

import java.util.List;

public class Produce implements Runnable {
    public Boolean is_produced=true;
    List<Integer> sharedList;

    public Produce(Boolean is_produced, List<Integer> sharedList) {
        this.is_produced = is_produced;
        this.sharedList = sharedList;
    }

    public Produce(List<Integer> sharedList) {
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("producing elements :"+sharedList.add(i));
        }
        is_produced=false;
    }
}
