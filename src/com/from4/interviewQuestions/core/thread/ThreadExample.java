package com.from4.interviewQuestions.core.thread;

import java.util.ArrayList;
import java.util.List;

class ThreadExample implements Runnable {
    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
        System.out.println("Run");
    }

    private static List<Thread> threadList = new ArrayList<>();

    static void getInfo(List<? extends Thread> threadList) {
        for (int i = 0; i < threadList.size(); i++) {
            Thread thread = threadList.get(i);
            System.out.print(thread.getName() + ", id: " + thread.getId() +
                    ", state: " + thread.getState() + ", priority: " +
                    thread.getPriority() + ", is alive: " + thread.isAlive() + ".\n");
        }
    }

    //if we call start twice = Exception in thread "main" java.lang.IllegalThreadStateException
    static void exceptionStart(ThreadExample example) {
        Thread exampleException = new Thread(example, "Exception");
        exampleException.start();
        exampleException.start();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadExample example = new ThreadExample();
        Thread thread = new Thread(example, "My Thread");
        Thread thread2 = new Thread(example, "My Thread2");
        threadList.add(thread);
        threadList.add(thread2);

        getInfo(threadList);

        thread.start();
        thread2.start();

        getInfo(threadList);

//        exceptionStart(example);


    }
}
