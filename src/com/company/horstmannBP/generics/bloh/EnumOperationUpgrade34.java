package com.company.horstmannBP.generics.bloh;

import java.util.Arrays;
import java.util.Collection;

enum EnumOperationUpgrade34 implements Opreration {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    EnumOperationUpgrade34(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }

    private static <T extends Enum<T> & Opreration> void test(Class<T> opSet, double x, double y) {
        for (Opreration op : opSet.getEnumConstants())
            System.out.printf("%s %s %s = %s%n", x, op, y, op.apply(x, y));
    }

    private static void test2(Collection<? extends EnumOperationUpgrade34> col, double x, double y) {
        for (Opreration op : col)
            System.out.printf("%s %s %s = %s%n", x, op, y, op.apply(x, y));
    }

    public static void main(String[] args) {
        Double x = Double.valueOf(9);
        Double y = Double.valueOf(6);
        test(EnumOperationUpgrade34.class, x, y);
        test2(Arrays.asList(EnumOperationUpgrade34.values()), x, y);
    }
}
interface Opreration {
    double apply(double x, double y);
}

enum BasicOperation implements Opreration {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol;
    }
}