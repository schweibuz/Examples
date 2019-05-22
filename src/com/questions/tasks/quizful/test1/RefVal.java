package com.questions.tasks.quizful.test1;

/**
 * Created by iMac on 02/12/2017.
 */
class RefVal {
    public static void main(String[] args) {
        metod1(n); //значение переменной n останется = 10;

        RefVal a = new RefVal();
        metod2(a); //значение переменной n станет = 12;

        a.l = 3;
        RefVal b = new RefVal();
        b.l = 6;
        metod4(a, b); //значение a.l останется = 3, b.l останется = 6;
    }

    static void metod1(int _n) {
        _n = _n * 3; //значение переменной _n станет = 30, но _n удалится после завершения работы метода;
    }

    static void metod2(RefVal _a) {
        _a.metod3(2); //изменяет состояние объекта, на который ссылаются как переменая _a, так и переменная a;
    }

    void metod3(int _p) {
        n = n + _p; //увеличивает значение переменной n на _p;
    }

    private static void metod4(RefVal _a, RefVal _b) {
        RefVal temp = _a;
        _a = _b; //значение _a.l теперь = 6;
        _b = temp; //значение _b.l теперь = 3;
//по завершении метода переменные _a и _b уничтожаются;
    }

    private static int n = 10;
    private int l;
}
