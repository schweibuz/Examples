package com.company.multithreading.example;

import java.util.Vector;

/**
 * Created by user123 on 14.12.2016.
 */
public class Consumer<T> implements Runnable {

    private final Vector<T> sharedQueue;
    private final int SIZE;

    public Consumer(Vector<T> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumed: " + consume());
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }
    }

    private T consume() throws InterruptedException {

        if (sharedQueue.isEmpty()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove(0);
        }
    }
}