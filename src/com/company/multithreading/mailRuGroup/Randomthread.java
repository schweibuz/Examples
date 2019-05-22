package com.company.multithreading.mailRuGroup;

public class Randomthread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Randomthread mailTechnoStream = new Randomthread();
            mailTechnoStream.start();
//            mailTechnoStream.join();
        }
    }
}
