package com.company.work.example;

import java.util.Scanner;

class G20 {
    public static void main(String[] args) throws Exception {
//        Scanner in = new Scanner(System.in);
//        System.out.println("How much money will you contribute every year? ");
//        double payment = in.nextDouble();
//        System.out.println("Interest rate in %: ");       //расчёт процентного роста вклада
//        double interestRate = in.nextDouble();
//        double balance = 0;
//        int year = 0;
//        String input;
//        do {
//            balance += payment;
//            double interest = balance * interestRate / 100;
//            balance += interest;
//            year++;
//            System.out.printf("After year %d, your balance is %,.2f%n", year, balance);
//            System.out.println("Ready to retire? (Y/N) ");
//            input = in.next();
//        }
//        while (input.equals("N"));


        for (int i = 0; i <= 10; i++) {
            System.out.print(i + "\t");
        }
        System.out.println();
        int i = 10;
        while (i >= 0) {
            System.out.print(i + "\t");
            i--;
        }
        try {
            Scanner in = new Scanner(System.in);
            fucking_metka:
            fucking_continue:
            while (true) {
                System.out.println("\nSelect an option: \n(1 - array, 2 - factorial, 3 - borzaya, 4 - stars, 5 - multyTab " +
                        "\n6 - sequence, 7 - 3for, 8 - two-dimensional array) ");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        int n;
                        System.out.println("Introduced the size of the array: ");
                        n = in.nextInt();
                        int[] mas = new int[n];
                        for (int f = 0; f < n; f++) {
                            mas[f] = (int) (Math.random() * 100);
                            mas[f] = f;
                        }
                        for (int f = 0; f < n; f++) {
                            System.out.print(mas[f] + "\t");
                        }
                        break;
                    case 2:
                        int fact;
                        System.out.println("Introduced the size of the factorial: ");
                        fact = in.nextInt();
                        Factory factory = new Factory();
                        long f = factory.factorial(fact);
                        System.out.println(f);
                        break;
                    case 3:
                        int[] arr = new int[1000];
                        int q = 5;
                        System.out.println("Enter a " + q + " number, or -1 to quit: ");
                        for (int count = 1; count <= q; count++) {
                            System.out.print("Enter a " + count + " number: ");
                            int w = in.nextInt();
                            if (w == -1) {
                                continue fucking_continue;
                            }
                            arr[q] += w;
                            if (count == q) {
                                System.out.println(arr[q]);
//                                System.out.println(java.util.Arrays.toString(arr));
                                continue fucking_continue;
                            }
                        }
                    case 4:
                        int i1, i2;
                        for (i1 = 0; i1 < 10; i1++) {
                            for (i2 = i1; i2 < 10; i2++) {      //ссылаемся на счётчит i1, поэтому отсаётся пройти меньше циклов
                                System.out.print("*");
                            }
                            System.out.print("\n");
                        }
                        continue fucking_continue;
                    case 5:
                        final int mt = 11;
                        for (int ii = 1; ii < mt; ii++) {
                            for (int jj = 1; jj < mt; jj++) {
                                System.out.print(ii + " * " + jj + " = " + ii * jj + "\t\t");
                            }
                            System.out.println();
                        }
                        continue fucking_continue;
                    case 6:
                        int i23 = 1;
                        int i7 = 10;
                        for (int u1 = 1; u1 < i7; u1++) {       //этот отвечает за количество строк
                            for (int u2 = 1; u2 < i7; u2++) {      //этот за количество символов в строке
                                System.out.print(i23 + "\t");
                                i23++;
                            }
                            System.out.println();       //переход на строку ниже
                        }
                        continue fucking_continue;
                    case 7:
                        for (int i6 = 1; i6 < 4; i6++) {
                            for (int j6 = 2 * i6 - 1; j6 < (2 * i6 - 1) + 4; j6++) {
                                System.out.print(j6 + "\t");
                            }
                            System.out.println();
                        }
                        continue fucking_continue;
                    case 8:
                        int sum = 0;
                        int[][] ar1 = new int[10][10];
                        for (int i3 = 0; i3 < 10; i3++) {
                            for (int j3 = 0; j3 < 10; j3++) {
                                ar1[i3][j3] = (i3 + 1) * (j3 + 1);
                                if (ar1[i3][j3] % 2 == 0) {
                                    sum += ar1[i3][j3];
                                    System.out.print(ar1[i3][j3] + "\t");
                                }

                            }
                            System.out.println();
                        }
                        System.out.println("Summa " + sum);
//                        System.out.println(Arrays.deepToString(ar1));
//                        for(int i4 [] : ar1) {
//                            for (int value1 : i4) {
//                                System.out.printCheck(value1+"\t");
//                            }
//                            System.out.println();
//                        }
                        continue fucking_continue;
                    default:
                        System.exit(666);
                }
            }
//            break fucking_metka;
//            continue fucking_continue;
        } catch (Exception ex) {
            System.err.println("Fucking beach");
        }
//        Scanner in = new Scanner(System.in);
//        System.out.println("\nHow many numbers do you need to draw? ");     //игра в лоттерею
//        int k = in.nextInt();
//        System.out.println("What is the highest number you can draw? ");
//        int n = in.nextInt();
//
//        int lotteryOdds = 1;
//        for (int j = 1; j <= k; j++) {      //вычислить биноминальный коэффициент
//            lotteryOdds = lotteryOdds * (n - j + 1) / j;
//        }
//        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");

//        String input = "1 fish 2 fish red fish blue fish red";
//
//        Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
//        System.out.println(s.nextInt());
//        System.out.println(s.nextInt());
//        System.out.println(s.next() + s.next());
//        System.out.println(s.next());
//        s.close();
    }
}