package com.company.horstmannBP.generics.bloh;

import java.util.HashMap;
import java.util.Map;

enum EnumOperation {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;
    EnumOperation(String symbol) {
        this.symbol = symbol;
    }
    abstract double apply(double x, double y);

    private static final Map<String, EnumOperation> stringToENum = new HashMap<>();
    static {
        for (EnumOperation op : values())
            stringToENum.put(op.toString(), op);
    }
    public static EnumOperation getString(String symbol) {
        return stringToENum.get(symbol);
    }

    public static EnumOperation inverse(EnumOperation op) {
        switch (op) {
            case PLUS: return EnumOperation.PLUS;
            case MINUS: return EnumOperation.MINUS;
            case TIMES: return EnumOperation.TIMES;
            case DIVIDE: return EnumOperation.DIVIDE;
            default: throw new AssertionError("Unknown op: " + op);
        }
    }

    public static void main(String[] args) {
        Double x = Double.valueOf(60);
        Double y = Double.valueOf(40);
        for (EnumOperation op : EnumOperation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        for (EnumOperation op : EnumOperation.values())
            System.out.println(inverse(op));
        System.out.println(EnumOperation.inverse(PLUS).apply(12, 33));
        System.out.println(EnumOperation.inverse(TIMES).apply(12, 33));
    }
}
