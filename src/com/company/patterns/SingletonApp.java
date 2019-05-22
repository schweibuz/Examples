package com.company.patterns;

class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;

        Thread [] t = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }
        for (int i = 0; i < SIZE; i++) {
            t[i].join();    //подождать выполнение потока t-итое
        }
        System.out.println(Singleton.counter);
    }
}

class R implements Runnable {
    @Override
    public void run() {
        Singleton.getInstance();
    }
}

//если сразу проинициализировать переменную то её инициализация
// произойдёт во время загрузки класса (поздняя инициализация(lazy initialization)
// предпочтительнее если создание экз. класса занимает много времени).
class Singleton {
    public static int counter = 0;
    private static volatile Singleton instance;   //если есть работа с разделяемыми ресурсами, надо делать волатильным

    private Singleton() {
        counter++;
    }

    public static Singleton getInstance() {     //ленивая инициализация дабл чек локинг
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                instance = new Singleton();
            }
        }
        return instance;
    }
    //Synchronize Accessor
//    private static SimpleSingleton instance;
//    private SimpleSingleton(){
//    }
//    public static synchronized SimpleSingleton getInstance(){
//        if (instance == null)
//            instance = new SimpleSingleton();
//        return instance;
//    }
}
