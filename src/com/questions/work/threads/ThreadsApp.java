package com.questions.work.threads;


class ThreadsApp {

    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        Thread thread = new Thread(dataManager);
        thread.start();
        dataManager.prepareData();
        dataManager.sendData();
    }
}

class DataManager implements Runnable {
    private static final Object monitor = new Object();
    private static boolean ready = false;

    public void prepareData() {
        synchronized (monitor) {
            System.out.println("Data prepared.");
            ready = true;
            monitor.notifyAll();
        }
    }

    public void sendData() {
        synchronized (monitor) {
            System.out.println("Waiting for data...");
            while (!ready) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Sending data...");
    }

    @Override
    public void run() {

    }
}
