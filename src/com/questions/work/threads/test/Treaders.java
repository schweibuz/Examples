package com.questions.work.threads.test;

/**
 * Created by iMac on 04/11/2017.
 */
class Treaders {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}

class Store {
    private static int count = 0;
    synchronized void put() {
        while (count >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("Producer put one new item.");
        System.out.println("Producers market has " + count + " items.");
        notify();
    }

    synchronized void get() {
        while (count < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println("Consumer arrived to the store.");
        System.out.println("Consumer buying one item, now market has " + count + " .");
        notify();
    }
}

class Producer implements Runnable {
    Store store = new Store();

    Producer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        for (int i = 1; i < 6; i++)
            store.put();
    }
}

class Consumer implements Runnable {
    Store store = new Store();

    Consumer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        for (int i = 1; i < 6; i++)
            store.get();
    }
}