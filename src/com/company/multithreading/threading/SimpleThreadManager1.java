package com.company.multithreading.threading;

/**
 * Created by iMac on 12/01/17.
 */
class SimpleThreadManager1 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Runnable first = new SimpleRunnable();
            Thread t = new Thread(first);
            t.start();
        }
    }
}

class SimpleRunnable implements Runnable {
    @Override
    public void run() {
        try {
            long pause = Math.round(Math.random() * 10000);
            Thread.sleep(pause);
            System.out.println("Simple Thread - pause=" + pause);
        } catch (InterruptedException i_ex) {

        }
    }
}
