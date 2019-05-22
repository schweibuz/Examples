package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 17/11/2017.
 */
class Hg {
    public static void main(String[] args) {
        double variable = getMaxValue(5.3, 39.6, -4);
        System.out.println(variable);
    }

    //метод, вычисляющий и возвращающий максимальное из произвольного количества значений.
    public static double getMaxValue(double ... values) {
        double largest = Double.MIN_VALUE;
        for (double v : values) {
            largest = v;
        }
        return largest;
    }
}
class Practice {
    public static void main(String ... args) {
        Boolean b = new Boolean("/true");
        System.out.println(b);
    }

    public static void main(String args) {
        Boolean b = new Boolean("/false");
        System.out.println(b == false);
    }
}
