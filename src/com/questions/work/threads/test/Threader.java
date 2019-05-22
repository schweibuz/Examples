package com.questions.work.threads.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by iMac on 02/11/2017.
 */
class Threader {
    public static void main(String[] args) {
        Threader threader = new Threader();
        Realization realization = new Realization();
        Confiscation confiscation = new Confiscation();
        Executorr executorr = new Executorr();
        Thread thread = new Thread(realization);
        Thread thread2 = new Thread(confiscation);

        try {
            thread.start();
            thread.join();
            thread2.start();
            thread2.join();
            for (int i = 0; i < 5; i++)
                executorr.execute(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static int sum = 0;
}

class Executorr {
    //        ExecutorService service = Executors.newFixedThreadPool(3);
//        ExecutorService service = Executors.newCachedThreadPool();    //.submit
    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();    //.schedule

    void execute(int num) {
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                    System.out.println("Hello i'm your thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }
}

class Realization implements Runnable {

    Threader threader = new Threader();
    int count = 5;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(300);
                System.out.println("Hello i'm your thread");
                threader.sum++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threader.sum);
    }
}

class Confiscation implements Runnable {

    Threader threader = new Threader();
    int count = 5;

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            try {
                Thread.sleep(300);
                System.out.println("Hello i'm your second thread");
                threader.sum++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threader.sum);
    }
}
