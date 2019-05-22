package com.company.test;

import java.util.Date;

/**
 * Created by iMac on 17.07.17.
 */
class ReserveCopy {
    private static Date start;
    private static Date end;

    public ReserveCopy(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " - " + end);
        }
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

    @Override
    public String toString() {
        return start + " - " + end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        ReserveCopy dates = new ReserveCopy(start, end);
        System.out.println(dates);

        start.setTime(1997);
        System.out.println(dates);

        dates.getEnd().setTime(2020);
        System.out.println(dates);
    }
}
