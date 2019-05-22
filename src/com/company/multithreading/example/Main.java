package com.company.multithreading.example;
import java.util.Vector;

public class Main {
    volatile private int v = 0;

    public static void create2Threads() {

        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Thread");
                }
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Runnable");
                }

            }
        };

        Thread thread1 = new Thread(runnable);

        thread.start();
        // thread.setDaemon(true);
        thread1.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("create2Threads finish");
    }

    public static final Object LOCK = new Object();

    public static void doSome() {

        synchronized (LOCK) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("do!");
        }
    }

    public static void sync() {

        System.out.println("Start");

        for (int i = 0; i < 100; i++) {
            new Thread() {
                @Override
                public void run() {
                    doSome();
                }
            }.start();
        }
    }

    public static void produces() {
        Vector sharedQueue = new Vector();
        int size = 4;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
        prodThread.start();
        consThread.start();
    }


    static class MyThread extends Thread {
        private volatile double[] array;
        int from;
        int to;
        double max;

        public MyThread(double[] array, int from, int to) {
            this.array = array;
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            for (int i = from; i < to; i++) {
                if (array[i] > max) {
                    max = array[i];
                }
            }
        }

        public double getMaximum() {
            return max;
        }
    }

    public static void findMax() {
        final double[] array = new double[1000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = Math.random();
        }


        MyThread thread1 = new MyThread(array, 0, 500000);
        MyThread thread2 = new MyThread(array, 500000, array.length);


        try {
            thread1.start();
            thread2.start();
            thread2.join();
            thread1.join();
            System.out.println(thread1.getMaximum() > thread2.getMaximum()
                    ? thread1.getMaximum() : thread2.getMaximum());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {





        /*Thread.sleep(100);*/

        //   create2Threads();
        //   sync();
        //  findMax();

        produces();

    }
}