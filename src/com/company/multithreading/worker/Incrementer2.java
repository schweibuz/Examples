package com.company.multithreading.worker;

import java.io.*;

/**
 * Created by iMac on 02.08.17.
 */
class Incrementer2 extends Thread {
    private volatile boolean mIsIncrement = true;
//    private volatile boolean mIsFinish = false;

    public void changeAction() {
        mIsIncrement = !mIsIncrement;
    }

//    public void finish() {
//        mIsFinish = true;
//    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {    //Этот метод возвращает состояние флага и сбрасывает его
                if (mIsIncrement) {
                    Program2.mValue++;
                } else {
                    Program2.mValue--;
                }
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    return;
                }
                System.out.print(Program2.mValue + " ");
            } else {
                return;
            }
        } while (true);
    }
}

class Program2 {
    static int mValue = 0;
    private static Incrementer2 mInc;

    private void runThread(Incrementer2 thread) {
        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.changeAction();
        }
//        mInc.finish();
        thread.interrupt();
    }


     String[] returnStopa() {
        BufferedReader br = null;
        String[] words = null;
        try {
            FileInputStream fl = new FileInputStream("/Users/iMac/Desktop/Stopi/stupni");
            br = new BufferedReader(new InputStreamReader(fl));
            String string;
            while ((string = br.readLine()) != null) {
//                words = string.replace(" ", " - ").split("", 1);
                words = string.replace(" ", " - ").split(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    public static void main(String[] args) {
        Program2 program2 = new Program2();

        mInc = new Incrementer2();
        System.out.print("Values: ");
        mInc.start();
        program2.runThread(mInc);
        System.out.println();

        StopaThread stopaThread = new StopaThread();
        stopaThread.start();
        try {
            stopaThread.join();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StopaThreadOverride stopaThreadOverride = new StopaThreadOverride();
        stopaThreadOverride.start();
        try {
            stopaThreadOverride.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StopaThredReverse stopaThredReverse = new StopaThredReverse();
        stopaThredReverse.start();

    }
}

class StopaThread extends Thread {
    private Program2 program2 = new Program2();
    private String[] strings = program2.returnStopa();

    private String st;

    @Override
    public void run() {
        if (!Thread.interrupted()) {
            for (int i = 0; i < strings.length; i++) {
                st = strings[i];
                for (String s : st.split(" ")) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    char[] chars = s.toCharArray();
                    for (int r = 0; r < chars.length; r++) {
                        System.out.print(chars[r]);
                    }
                }
            }
        } else
            return;
    }
}

class StopaThreadOverride extends Thread {
    private Program2 program2 = new Program2();
    private String[] strings = program2.returnStopa();

    @Override
    public void run() {
        if (!Thread.interrupted()) {
            for (int i = 1; i < strings.length; ++i) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(strings[strings.length - i]);
            }
            System.out.print(strings[0] + "\n");
        } else {
            return;
        }
    }
}

class StopaThredReverse extends Thread {
    private Program2 program2 = new Program2();
    private String[] strings = program2.returnStopa();

    private String[] strReverse() {
        String st = "";
        String[] words = null;
        String strin;
        for (int i = 0; i < strings.length; i++) {
            st += strings[i];
            strin = new StringBuffer(st).reverse().toString();
            words = strin.toUpperCase().replaceAll(
                    "-", "  ").split("");
        }
        return words;
    }

    private String[] stringi = strReverse();
    private int count = 0;

    @Override
    public void run() {
        if (!Thread.interrupted()) {
            for (int i = 0; i < stringi.length; ++i) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(stringi[i]);
                count = stringi.length;
            }
            System.out.println("\nCount of characters: " + count + " ");
        } else {
            return;
        }
    }
}