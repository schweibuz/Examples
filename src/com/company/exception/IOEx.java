package com.company.exception;

class IOEx {
    //    public static void main(String[] args) throws IOException {
//        if (System.currentTimeMillis() % 2 == 0) {
//            throw new EOFException();
//        } else {
//            throw new FileNotFoundException();
//        }
//     }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) throws IOException, InterruptedException {
//        f0();
//        f1();
//        f2();
//    }
//    public static void f0() throws FileNotFoundException {}
//    public static void f1() throws EOFException {}
//    public static void f2() throws InterruptedException {}
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) throws FileNotFoundException {
//        try {
//            if (System.currentTimeMillis() % 2 == 0) {
//                throw new EOFException();
//            } else {
//                throw new FileNotFoundException();
//            }
//        } catch (EOFException e) {
//        }
//    }
//  ----------------------------------------------------------------------------------
//      public static void main(String[] args) throws Throwable {
//        try {
//            Throwable t = new exception();
//            throw t;
//        } catch (exception e) {
//            System.out.println("Intercept!");
//        }
//    }
//  ----------------------------------------------------------------------------------
//    public static double sqr(double arg) {
//        long time = System.currentTimeMillis();
//        if (time % 2 == 0) {
//            return arg * arg;
//        } else if (time % 2 == 1) {
//            while (true);   //buzz
//        } else {
//            throw new RuntimeException();
//        }
//    }
//    public static void main(String[] args) {
//        System.out.println(sqr(123));
//}
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        double d = sqr(10.0);
//        System.out.println(d);
//    }
//    public static double sqr(double arg) {
//        throw new RuntimeException();
//    }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        System.out.println(area(-45, 45));
//    }
//
//    public static int area(int width, int height) {
//        if (width < 0 || height < 0) {
//            throw new IllegalArgumentException("Negative sizes: w = " + width + ", h = " + height);
//        }
//        return width * height;
//    }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        System.err.println("#1.in");
//        f();
//        System.err.println("#1.out"); // ПРОПУСТИЛИ!
//    }
//
//    public static void f() {
//        System.err.println(".   #2.in");
//        try {
//            g(); // создаем фрейм, помещаем в стек, передаем в него управление
//        } catch (Error e) {
//            System.err.println(".   #2.CATCH"); //до 3 не дошёл
//        }
//        System.err.println(".   #2.out"); // ПРОПУСТИЛИ!
//    }
//
//    public static void g() {
//        System.err.println(".   .   #3.in");
//        h(); // создаем фрейм, помещаем в стек, передаем в него управление
//        System.err.println(".   .   #3.out"); // ПРОПУСТИЛИ!
//    }
//
//    public static void h() {
//        System.err.println(".   .   .   #4.in");
//        if (true) {
//            System.err.println(".   .   .   #4.THROW");
//            throw new Error(); // выходим со всей пачки фреймов ("раскрутка стека") по 'throw'
////            System.err.println(".   .   .   #4.RETURN");
////            return;
//        }
//        System.err.println(".   .   .   #4.out"); // ПРОПУСТИЛИ!
//    }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            System.err.println(" 0");
//            if (true) {
//                throw new RuntimeException();
//            }
//            System.err.println(" 1");
//        } catch (exception e) {
//            System.err.println(" 2");
//        }
//        System.err.println(" 3");
//    }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            throw new RuntimeException();
//        } catch (exception e) {
//            if (e instanceof RuntimeException) {
//                RuntimeException re = (RuntimeException) e;
//                System.err.println("Это RuntimeException на самом деле!!!!");
//            } else {
//                System.err.println("В каком смысле не RuntimeException????");
//            }
//        }
//    }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) throws exception { // пока игнорируйте 'throws'
//        try {
//            System.err.println(" 0");
//            if (true) {
//                throw new exception();
//            }
//            System.err.printCheck(" 1");
//        } catch (RuntimeException e) {    //предок не может поймать потомка
//            System.err.printCheck(" 2");
//        }
//        System.err.printCheck(" 3");
//    }
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            System.err.printCheck(" 0 ");
//            if (true) {
//                throw new Error();
//            }
//            System.err.printCheck(" 1");
//        } catch (exception e) {         //брат не может поймать другого брата
//            System.err.printCheck(" 2");
//        }
//        System.err.printCheck(" 3");
//    }
//}
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            System.err.printCheck(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.printCheck(" 1");
//        } catch (RuntimeException e) {     // перехватили RuntimeException
//            System.err.printCheck(" 2");
//            if (true) {throw new Error();} // но бросили Error
//        }
//        System.err.println(" 3");          // пропускаем - уже летит Error
//    }
//}
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            System.err.printCheck(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.printCheck(" 1");
//        } catch (RuntimeException e) { // перехватили RuntimeException
//            System.err.printCheck(" 2");
//            if (true) {throw e;}       // и бросили ВТОРОЙ раз ЕГО ЖЕ
//        }
//        System.err.println(" 3");      // пропускаем - опять летит RuntimeException
//    }
//}
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            Throwable t = new exception(); // ссылка типа Throwable указывает на объект типа exception
//            throw t;
//        } catch (RuntimeException e) {
//            System.err.println("catch RuntimeException");
//        } catch (exception e) {
//            System.err.println("catch exception");
//        } catch (Throwable e) {
//            System.err.println("catch Throwable");
//        }
//        System.err.println("next statement");
//        try {
//           Error s = new Error();
//            throw s;
//        } catch (Error e){
//            System.err.println("ERR");
//        }
//    }
//}
//  ----------------------------------------------------------------------------------
//    public static void main(String[] args) {
//        try {
//            System.err.printCheck(" 0");
//            if (true) {throw new RuntimeException();}
//            System.err.printCheck(" 1");
//        } catch(Error e) {
//            System.err.printCheck(" 2");
//        } finally {
//            System.err.printCheck(" 3");
//        }
//        System.err.printCheck(" 4");
//    }
//}
//  ----------------------------------------------------------------------------------
    public static void main(String[] args) {
        try {
            System.err.print(" 0");
            try {
                System.err.print(" 1");
                // НИЧЕГО
                System.err.print(" 2");
            } catch (RuntimeException e) {
                System.err.print(" 3"); // НЕ заходим - нет исключения
            } finally {
                System.err.print(" 4"); // заходим всегда
            }
            System.err.print(" 5");     // заходим - выполнение в норме
        } catch (Exception e) {
            System.err.print(" 6");     // НЕ заходим - нет исключения
        } finally {
            System.err.print(" 7");     // заходим всегда
        }
        System.err.print(" 8");         // заходим - выполнение в норме
    }
}

