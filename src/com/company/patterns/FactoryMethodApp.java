package com.company.patterns;

import java.util.Date;

class FactoryMethodApp {
    public static void main(String[] args) {

        Watch watch = new DigitalWatch();
        watch.showTime();
        Watch watch1 = new RomeWatch();
        watch1.showTime();

        WatchMaker maker1 = getMakerByName("Digital");
        WatchMaker maker = new RomeWatchMaker(); //new DigitalWatchMaker();
        Watch watch2 = maker.createWatch();
        watch2.showTime();
        Watch watch3 = maker1.createWatch();
        watch3.showTime();

    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomeWatchMaker();

        throw new RuntimeException("adsfadsf" + maker);
    }
}


interface Watch {
    void showTime();
}


class DigitalWatch implements Watch {
    public void showTime() {
        System.out.println(new Date());
    }
}


class RomeWatch implements Watch {
    public void showTime() {
        System.out.println("VII-XX");
    }
}


interface WatchMaker {
    Watch createWatch();
}


class DigitalWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new DigitalWatch();
    }
}


class RomeWatchMaker implements WatchMaker {
    public Watch createWatch() {
        return new RomeWatch();
    }
}