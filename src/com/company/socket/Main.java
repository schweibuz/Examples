package com.company.socket;

import java.io.IOException;

/**
 * Created by Roman Petrov
 */
class Main {
    public static void main(String s[]) {

        new Thread(){
            @Override
            public void run() {
                try {
                    new Server().start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    new Client().start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    sleep(1000);
//                    new Client().start();
//                } catch (exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();

    }
}
