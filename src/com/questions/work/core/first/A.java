package com.questions.work.core.first;

import java.io.*;

/**
 * Created by iMac on 28/10/2017.
 */
class A implements I {
    A() throws FileNotFoundException {
    }

    @Override
    public void say() {
        System.out.println("Ask me!");
    }

    @Override
    public void F() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        A a = new A();
        String string = null;
//        try {
//
//            a.output.write(a.reader.read());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println(string);

        StringBuilder stringBuilder = new StringBuilder();
        for (char i = 'A'; i < 'Z'; i++)
            stringBuilder.append(i + " ");
//        stringBuilder.reverse();
        System.out.println(stringBuilder);
    }

//    Reader reader = new BufferedReader(new InputStreamReader(System.in));
//    OutputStream output = new FileOutputStream("/Users/iMac/Desktop/asdf.txt");

}

interface I {
    public void F();
    public void say();
}
