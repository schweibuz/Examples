package com.spring2019.interviewQuestions.core.thread;

class DaemonThread extends Thread{
    @Override
    public void run() {
        if (Thread.currentThread().isDaemon()) {
            System.out.println("daemon thread work");
        } else {
            System.out.println("user thread work");
        }
    }

    public static void main(String[] args) {
        DaemonThread dt1 = new DaemonThread();
        DaemonThread dt2 = new DaemonThread();
        DaemonThread dt3 = new DaemonThread();
        dt1.setDaemon(true);

        dt1.start();
        dt2.start();
        dt3.start();
    }

}
