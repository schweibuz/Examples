package com.company.patterns.workp;

class SingletonTest {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        Thread r[] = new Thread[SIZE];
        for (int i = 0; i < SIZE; i++) {
            r[i] = new Thread(new R());
            r[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            r[i].join();
        }
        System.out.println(Singleton.counter);
//        Singleton singleton = Singleton.getInstance();
//        singleton.get();
    }
}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    public static int counter = 0;
    private static volatile Singleton instance;
    private Singleton(){
        counter++;
    }
    public static Singleton getInstance() {
        if (instance == null){
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
//    public void get() {
//        System.out.println("Hello, my baby!");
//    }
}


//        final int SIZE = 1000;
//
//        Thread t[] = new Thread[SIZE];
//
//        for (int i = 0; i < SIZE; i++) {
//            t[i] = new Thread(new RuntTest());
//            t[i].start();
//        }
//        for (int i = 0; i < SIZE; i++) {
//            t[i].join();
//        }
//        System.out.println(Singleton.counter);
//    }
//}
//
//class RuntTest implements Runnable {
//    @Override
//    public void run() {
//        Singleton.getInstance();
//    }
//}
//
//class Singleton {
//    public static int counter = 0;
//    private static volatile Singleton instance;
//    private Singleton() {
//        counter++;
//    }
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized (Singleton.class) {
//                if (instance == null) {
//                    instance = new Singleton();
//                }
//            }
//        } return instance;
//    }
//}