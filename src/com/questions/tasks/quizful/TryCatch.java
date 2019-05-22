package com.questions.tasks.quizful;

//import sun.misc.Unsafe;
//
//import java.io.*;
//import java.lang.reflect.Field;
//
//class TryCatch {
//    public static void main(String[] args) throws MyException {
//
////        int result = 0;
////
////        try {
////            result = getAreaValue(-1, 100);
////        } catch (IllegalArgumentException e) {
////            ForLogger.getLogger(TryCatch.class.getName()).log(
////                    new LogRecord(Level.WARNING, "В метод вычисления " +
////                            "площади был передан аргумент с негативным значением!"));
////            throw new MyException(e);
////        }
////        System.out.println("Result is : " + result);
//
//        getUnsafe().throwException(new IOException("This is checked exception"));
//    }
//
//    public static int getAreaValue(int x, int y) {
//        if (x < 0 || y < 0) throw new IllegalArgumentException(
//                "value of 'x' or 'y' is negative: x=" + x + ", y=" + y);
//        return x * y;
//    }
//
//    public static Unsafe getUnsafe() {
//        Unsafe unsafe = null;
//        try {
//            Field f = Unsafe.class.getDeclaredField("theUnsafe");
//            f.setAccessible(true);
//            unsafe = (Unsafe) f.get(null);
//        } catch (ReflectiveOperationException e) {
//            System.out.println("Who cares");
//        }
//        return unsafe;
//    }
//}
//
//
//class MyException extends Exception {
//    public MyException(Throwable e) {
//        initCause(e);
//    }
//}
//
//
//class Main {
//    public static void main(String[] args) {
//        FileInputStream fis = null;
//        try{
//            fis = new FileInputStream("/");
//        }catch (FileNotFoundException ex){
//            System.out.println("Oops, FileNotFoundException caught");
//        }catch (IOException e) {
//            System.out.println("IOEXCEOTION");
//        }
//    }
//
//    static String readers(String path) {
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
//            return reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "DF";
//    }
//}