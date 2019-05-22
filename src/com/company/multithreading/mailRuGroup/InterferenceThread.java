package com.company.multithreading.mailRuGroup;

public class InterferenceThread extends Thread {
    private final InterferenceExample checker;
    private static volatile int i;
//    private static Object lock = new Object();

    public InterferenceThread(InterferenceExample checker) {
        this.checker = checker;

    }

    public void run() {
        while (!checker.stop()) {
            increment();
        }
    }

    public void increment() {   //synchronized static
        synchronized (checker) {    //lock
            i++;
        }
    }

    public int getI() {
        return i;
    }
}

//class StateObject {
//    private int i;
//
//    public synchronized void increment() {
//        i++;
//    }
//
//    public int getI() {
//        return i;
//    }
//}
