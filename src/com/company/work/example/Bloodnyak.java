package com.company.work.example;

import java.io.IOException;

class Bloodnyak {
    public static void main(String[] args) throws IOException {
//        Scanner scn = new Scanner(System.in);
//        try {
//            int i = scn.nextInt();
//            int j = scn.nextInt();
//            System.out.println(i+j);
//            if ((i + j) % 2 == 0 && (i + j) != 0) {
//                System.out.println("Your number is valid: " + (i + j));
//            } else if ((i + j) % 1 == 0) throw new Error();
//        } catch (Error e) {
//            System.err.println(e);
//        }
//        Scanner scn = new Scanner(System.in);
//        int a = scn.nextInt();
//        int b = scn.nextInt();
//        int c = scn.nextInt();
//        Math.abs(a);
//        Math.abs(b);
//        Math.abs(c);
//        int tmp = Math.min(a, b);
//        int min = Math.min(tmp, c);
//        System.out.println(min);
//        scn.close();
        NOD nod = new NOD("String", "Stirnger");
        System.out.println(nod.nodE(187, 517));
        System.out.println(nod);

        int a = 35, b = 25, c = 32, d = 33;
        int min = Math.min(a, b);
        int min2 = Math.min(min, c);
        int min3 = Math.min(min2, d);
        System.out.println(min3);

        int z = 10, x = 11;
        System.out.println(z + " " + x);
        int tmp = x;
        x = z;
        z = tmp;
        System.out.println(z + " " + x);
    }
}

class NOD {
    private String a;
    private String b;

    public NOD(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return "a = " + a + ", b = " + b;
    }

    public int nodE(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
//        NOD1 nod1 = new NOD1();
//        int NIDE = nod1.NOD(18, 18);
//        System.out.println(NIDE);
//    }
//}
//
//class NOD1 {
//    public int NOD(int a, int b) {
//        while (a != 0 && b != 0) {
//            if (a > b) {
//                a = a % b;
//            } else {
//                b = b % a;
//            }
//        }
//        return a + b;
//    }
//}
// Так как после выполнения цикла одна из
// переменных гарантированно равна нулю, то
// сумма (a + b) будет НОД