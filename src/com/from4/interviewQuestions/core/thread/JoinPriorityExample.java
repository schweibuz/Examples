package com.from4.interviewQuestions.core.thread;

import java.util.ArrayList;
import java.util.List;

class JoinPriorityExample extends Thread {
    @Override
    public void run() {
        for (int i = 5; i > 0; i--) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(i + " : " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinPriorityExample t1 = new JoinPriorityExample();
        JoinPriorityExample t2 = new JoinPriorityExample();
        JoinPriorityExample t3 = new JoinPriorityExample();
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        List<JoinPriorityExample> joinExampleList = new ArrayList<>();
        joinExampleList.add(t1);
        joinExampleList.add(t2);
        joinExampleList.add(t3);
        t1.start();
        try {
            ThreadExample.getInfo(joinExampleList);
            //join() waits for a thread to die, throws InterruptedException
            t1.join(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        t2.start();
//        t2.join();  //!!!
        t3.start();
    }
}
