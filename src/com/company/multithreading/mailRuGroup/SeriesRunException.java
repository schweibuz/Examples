package com.company.multithreading.mailRuGroup;

public class SeriesRunException extends Thread {
    private static int currentMax = 1;
    private int mainId;
    private final Object waitObject;

    public static void main(String[] args) {
        SeriesRunException.example();
    }

    public SeriesRunException(int id, Object waitObject) {
        this.mainId = id;
        this.waitObject = waitObject;
    }

    public static void example() {
        Object waitObject = new Object();
        for (int i = currentMax; i <= 10; ++i){
            Thread thread = new SeriesRunException(i, waitObject);
            thread.start();
        }
    }

    public void run() {
        try {
            System.out.println("Start run of thread: " + mainId);
            synchronized (waitObject) {
                while (mainId > currentMax) {
                    waitObject.wait();  //ставлю в очередь поток
                }
                currentMax++;
                System.out.println("Hello from thread: " + mainId);
                waitObject.notifyAll(); //бужу всех кто заснул
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
