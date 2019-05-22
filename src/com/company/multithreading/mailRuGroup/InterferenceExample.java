package com.company.multithreading.mailRuGroup;

import java.util.concurrent.atomic.AtomicInteger;

public class InterferenceExample {
    public static void main(String[] args) throws InterruptedException {
        InterferenceExample interferenceExample = new InterferenceExample();
        interferenceExample.example();
    }
    private static final int HunderMillion = 100_000_000;
    private AtomicInteger counter = new AtomicInteger();


    public boolean stop(){
        return counter.incrementAndGet() > HunderMillion;
    }

    public void example() throws InterruptedException {
        InterferenceThread thread1 = new InterferenceThread(this);
        InterferenceThread thread2 = new InterferenceThread(this);
        thread1.start();
        thread2.start();
        thread1.join();
        System.out.println("Expected: " + HunderMillion);
        System.out.println("Result: " + thread1.getI());
    }
}
