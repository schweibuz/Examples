package com.company.patterns.workp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iMac on 10.08.17.
 */
class MyObserverStation {
    public static void main(String[] args) {
        ConcreteObservable console = new ConcreteObservable();
        console.addObserver(new ConcreteConsoleObserver());
        console.setWerification(18, 745);
        console.setWerification(23, 750);
        console.addObserver(new ConcreteFileObserver());
        console.setWerification(32, 720);

    }
}

interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}

interface Observer {
    void handleEvent(int temperature, int pressure);
}

class ConcreteObservable implements Observable {
    int temperature;
    int pressure;
    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.handleEvent(temperature, pressure);
        }
    }

    public void setWerification(int temperature, int pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObserver();
    }
}

class ConcreteConsoleObserver implements Observer {

    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.printf("Current temperature: %d, current pressure: %d\n", temperature, pressure);
    }
}

class ConcreteFileObserver implements Observer {
    @Override
    public void handleEvent(int temperature, int pressure) {
        File f;
        try {
            f = File.createTempFile("newObserverFile", ".txt", new File("/Users/iMac/Desktop/Stopi/"));
            PrintWriter pw = new PrintWriter(f);
            pw.printf("Current temperature: %d, current pressure: %d\n", temperature, pressure);
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}