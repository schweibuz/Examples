package com.questions.tasks.tproger;

/**
 * Created by iMac on 30/11/2017.
 * Represent code possible
 */
class First {
    public static void main(String[] args) {
        First first = new First();
        System.out.println(first.show());
    }

    First first = new First();

    int show() {
        return (true ? null : 0);
    }
}


class A{
    public static void show(){
        System.out.println("Static method called");
    }

    static int a = 1111;
    int b = a++;
    int c = ++a;
    static {
        a = a-- - --a;
    }
    {
        a = a++ + ++a;
    }

    public static void main(String[] args)  {
        A obj = null;
        obj.show();

        System.out.println(a);
        A obj2 = new A();

        System.out.println(a);
        A obj23 = new A();
        System.out.println(a);
        System.out.println(obj2.b);
        System.out.println(obj2.c);

        Integer i1 = 128;
        Integer i2 = 128;
        System.out.println(i1 == i2);

        Integer i3 = 127;
        Integer i4 = 127;
        System.out.println(i3 == i4);

        Integer i5 = 122;
        Integer i6 = 122;
        System.out.println(i5 == i6);

        String s = "ONE" + 1 + 2 + "THREE" + 3 + 4 + 5 + "SIX" + 6;
        System.out.println(s);

        System.out.println(method1(11));

        System.out.println(java.util.Optional.of(null));
    }

    static int method1(int i)
    {
        return method2(i *= 11);
    }

    static int method2(int i)
    {
        return method3(i /= 11);
    }

    static int method3(int i)
    {
        return method4(i -= 11);
    }

    static int method4(int i)
    {
        return i += 11;
    }
}