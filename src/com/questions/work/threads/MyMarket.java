package com.questions.work.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by iMac on 02/11/2017.
 */
class MyMarket {
    public static void main(String[] args) {
        Store2 store2 = new Store2();
        Consumer2 consumer2 = new Consumer2(store2);
        Producer2 producer2 = new Producer2(store2);
        producer2.store2.ask();
        new Thread(producer2).start();
        new Thread(consumer2).start();
    }
}

class Store2 {
    static int count = 0;
    String system = null;

    void ask() {
        String choose = null;
        System.out.println("How system do you need? 1.Macintosh 2.Microsoft 3.Linux");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            choose = reader.readLine();
            if (!choose.equals("1") && !choose.equals("2") && !choose.equals("3")) {
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (choose) {
            case "1":
                system = "Macintosh";
                break;
            case "2":
                system = "Microsoft";
                break;
            case "3":
                system = "Linux";
                break;
        }
    }

    synchronized void put() {
        while (count >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println("Producer delivered " + system + " to the Store.");
        System.out.println("Producers store has " + count + " systems.");
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
        System.out.println("Consumer arrived to the Store.");
        System.out.println("Consumer buying one operating system. Remain " + count);
        notify();
    }
}

class Consumer2 implements Runnable {
    Store2 store2 = new Store2();

    Consumer2(Store2 store2) {
        this.store2 = store2;
    }
    @Override
    public void run() {
        for (int i = 1; i < 6; i++)
            store2.get();
    }
}

class Producer2 implements Runnable {
    Store2 store2 = new Store2();

    Producer2(Store2 store2) {
        this.store2 = store2;
    }
    @Override
    public void run() {
        for (int i = 1; i < 6; i++)
            store2.put();
    }
}