package com.company.generics.genexam;

import java.util.ArrayList;
import java.util.List;

class GenericsExample<T> implements Comparable {

    private T t;

    public T get() {
        return this.t;
    }

    public void set(T t) {
        this.t = t;
    }

    public static void main(String[] args) {

        GenericsExample<String> type = new GenericsExample<>();
        type.set("Officer");
        System.out.println(type.get());

        GenericsExample type2 = new GenericsExample();
        type2.set("Military");
//        type2.set(10);
        System.out.println(type2.get());

        boolean isEqual = isEqual(type, type2);
        System.out.println("isEqual: " + isEqual);

        int compare = compare(type, type);
        System.out.println("compare: " + compare);

        List<Double> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + 0.15);
//            System.out.printCheck(list.get(i) + ", ");
        }
        printData(list);
        System.out.println("\nSum: " + sum(list));

        List<? extends Integer> intList = new ArrayList<>();
        List<? extends Number> numList = intList;
        List<Object> superList = new ArrayList<>();
        superList.add("Squad");
        addIntegers(superList);
        printData(superList);

    }

    //Generic method
    public static <T> boolean isEqual(GenericsExample<T> g1, GenericsExample<T> g2) {
        return g1.get().equals(g2.get());
    }

    //Bounded type parameters
    public static <T extends Comparable<T>> int compare(T t1, T t2) {
        return t1.compareTo(t2);
    }

    @Override
    public int compareTo(Object o) {
        GenericsExample element = (GenericsExample) o;
        if (this.t.hashCode() > element.t.hashCode()) return 1;
        if (this.t.hashCode() < element.t.hashCode()) return -1;
        else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o.getClass() == getClass())) return false;
        GenericsExample<?> that = (GenericsExample<?>) o;
        return t == that.t;
    }

    @Override
    public int hashCode() {
        return t.hashCode() * 31 + t.toString().length();
    }

    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void printData(List<?> list) {
        for (Object o : list)
            System.out.print(o + " :: ");
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(new Integer(50));
    }
}

