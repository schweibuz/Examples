package com.questions.work.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by iMac on 02/11/2017.
 */
class ThreadRealize {
    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        ThreadTest2 threadTest2 = new ThreadTest2();
        Thread thread = new Thread(threadTest);
        Thread thread2 = new Thread(threadTest);
        Thread thread3 = new Thread(threadTest2);
        for (int i = 0; i < 10; i++) {
            thread.run();
            thread2.run();
//            thread3.run();
            try {
                thread.join();
                thread2.join();
                thread3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread3 thread4 = new Thread3();
        thread4.start();

    }

    static class ThreadTest implements Runnable {
        static int i = 0;

        @Override
        public void run() {
            i++;
            try {
                Thread.sleep(100);
                System.out.println(i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadTest2 implements Runnable {

        static int j = 0;

        @Override
        public void run() {
            j++;
            try {
                Thread.sleep(200);
                System.out.println("2 " + j);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Thread3 extends Thread {
    @Override
    public void run() {
        System.out.println("3 thread");
    }
}


class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // возвращает имя потока, который выполняет callable таск
        return Thread.currentThread().getName();
    }

    public static void main(String args[]){
        //Получаем ExecutorService утилитного класса Executors с размером пула потоков равному 10
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //создаем список с Future, которые ассоциированы с Callable
        List<Future<String>> list = new ArrayList<Future<String>>();
        // создаем экземпляр MyCallable
        Callable<String> callable = new MyCallable();
        for(int i=0; i< 100; i++){
            //сабмитим Callable таски, которые будут
            //выполнены пулом потоков
            Future<String> future = executor.submit(callable);
            //добавляя Future в список,
            //мы сможем получить результат выполнения
            list.add(future);
        }
        for(Future<String> fut : list){
            try {
                // печатаем в консоль возвращенное значение Future
                // будет задержка в 1 секунду, потому что Future.get()
                // ждет пока таск закончит выполнение
                System.out.println(new Date()+ "::" + fut.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();
    }

}