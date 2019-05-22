package com.company.multithreading.example;
import java.util.Vector;

/**
 * Created by Roman Petrov
 */
public class Producer implements Runnable {

    private final Vector sharedQueue;
    private final int SIZE;

    public Producer(Vector sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(300);
                produce(Math.random());
                System.out.println("Produced");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(double i) throws InterruptedException {

        synchronized (sharedQueue) {
            if(sharedQueue.size() == SIZE){
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                sharedQueue.wait();
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}