package com.questions.work.core.first;

/**
 * Created by iMac on 28/10/2017.
 */
class StaticClass {
    int a;
    int v;
    String s;

    StaticClass(String s) {
        this.s = s;
    }

    void print() {
        System.out.println("Hello");
        System.out.println(s.intern());
    }

    StaticClass getStaticClass(StaticClass staticClass) {
        staticClass = new StaticClass("Vasya");
        return staticClass;
    }

    @Override
    public String toString() {
        return "StaticClass{" +
                "a=" + a +
                ", v=" + v +
                ", s='" + s + '\'' +
                '}';
    }

    static class InnerStatic implements Cloneable {
        String s;
        static int p;

        static void counter() {
            p++;
        }

        void strPrint() {
            System.out.println(s);
        }

        void print(StaticClass staticClass) {
            int r = staticClass.a = 10;
            int t = staticClass.v = 1200;
            System.out.println(t / r);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}

class Test implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    String string = "«O» большое и «o» малое (\n" +
            "o) — математические обозначения для сравнения асимптотического поведения (асимптотики) функций. Используются в различных разделах математики, но активнее всего — в математическом анализе, теории чисел и комбинаторике, а также в информатике и теории алгоритмов. Под асимптотикой понимается характер изменения функции при её стремлении к определённой точке.\n" +
            "n, характеризующего количество входной информации алгоритма, время работы алгоритма будет возрастать не быстрее, чем некоторая константа, умноженная на \n" +
            "\\left |f(x)\\right |/\\left |g(x)\\right | стремится к нулю).";

    public static String removeChar(String str, char ch) {
        return str == null ? null : str.replaceAll(Character.toString(ch), "*");
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        StaticClass.InnerStatic nStat = new StaticClass.InnerStatic();
        StaticClass sStat = new StaticClass("Petya");
        nStat.print(sStat);
        sStat.print();

        for (int i = 0; i < 20; i++)
            StaticClass.InnerStatic.counter();
        Test test = new Test();
        StaticClass.InnerStatic n2 = (StaticClass.InnerStatic) nStat.clone();

        System.out.println(StaticClass.InnerStatic.p);
        System.out.println(sStat);
        System.out.println(sStat.getStaticClass(sStat));
//        System.out.println(n2.);
        System.out.println(test.removeChar(test.string, 'м'));
    }
}
