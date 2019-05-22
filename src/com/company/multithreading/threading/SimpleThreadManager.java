package com.company.multithreading.threading;

/**
 * Created by iMac on 12/01/17.
 */
public class SimpleThreadManager {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread first = new SimpleThread();
            first.start();
        }
    }
}

class SimpleThread extends Thread {
    @Override
    public void run() {
        try {
            long pause = Math.round(Math.random() * 2000);
            Thread.sleep(pause);
            System.out.println("Simple Thread - pause=" + pause);
        } catch (InterruptedException i_ex) {

        }
    }
}

//    public static void main(String[] arg) {       //тоже самое но с использованием анонимного класса
//        for (int i = 0; i < 10; i++) {
//            Thread first = new Thread() {
//                @Override
//                public void run() {
//                    try {
//                        long pause = Math.round(Math.random() * 2000);
//                        Thread.sleep(pause);
//                        System.out.println("Simple Thread - pause=" + pause);
//                    } catch (InterruptedException i_ex) {
//                    }
//                }
//            };
//            first.start();
//        }
//    }