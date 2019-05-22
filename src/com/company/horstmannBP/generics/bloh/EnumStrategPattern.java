package com.company.horstmannBP.generics.bloh;

enum EnumStrategPattern {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),
    THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY), SATURDAY(PayType.WEEKEND),
    SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    EnumStrategPattern(PayType symbol) {
        this.payType = symbol;
    }

    double pay(double hours, double payRate) {
        return payType.pay(hours, payRate);
    }

    private enum PayType {
        WEEKDAY {
            double overtimePay(double hours, double payRate) {
                return hours <= NORM ? 0 : (hours - NORM) * payRate / 2;
            }
        },
        WEEKEND {
            double overtimePay(double hours, double payRate) {
                return hours * payRate / 2;
            }
        };

        private static final int NORM = 8;

        abstract double overtimePay(double hours, double payRate);

        double pay(double hours, double payRate) {
            double basePay = hours * payRate;
            return basePay + overtimePay(hours, payRate);
        }
    }

    public static void main(String[] args) {
        System.out.println(EnumStrategPattern.MONDAY.pay(10, 10));
        System.out.println(EnumStrategPattern.SUNDAY.pay(10, 10));
    }
}