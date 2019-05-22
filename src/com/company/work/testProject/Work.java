package com.company.work.testProject;

/**
 * Created by iMac on 23.08.17.
 */
class Work implements Action, Sort {
    Employee meow = new Employee.Builder().firstName("Kisa").lastName("Suchka").age(52).salary(60000).build();
    @Override
    public void coffee() {
        System.out.println(meow + "I like cappuccino.");
    }

    @Override
    public void speak() {
        System.out.println("I've quote good knowledge of OOP principles.");
    }

    @Override
    public void walk() {
        System.out.println("I'm going to work at 9 o'clock.");

    }

    @Override
    public int[] bubbleSort(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas.length - i; j++) {
                if (mas[j - 1] > mas[j]) {
                    int tmp = mas[j - 1];
                    mas[j - 1] = mas[j];
                    mas[j] = tmp;
                }
            }
        }
        return mas;
    }
}
