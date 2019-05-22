package com.company.horstmannBP.Collections.listETC;

import java.util.*;

/**
 * Created by user123 on 26.12.2016.
 */
class ListVerySimple {
    public static void main(String[] args) {

    }
    public interface Observer {
        void onValueChanged(Object newValue);
    }

    private Object value;

    private final java.util.List<Observer> observers = new LinkedList<Observer>();

    public Object getValue() {
        return value;
    }

    public void setValue(Object newValue) {
        this.value = newValue;
        notifyOfValueChanged(newValue);
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public boolean removeObserver(Observer observer) {
        return observers.remove(observer);
    }

    private void notifyOfValueChanged(Object newValue) {
        for (Observer observer : observers) {
            if (observer != null) {
                observer.onValueChanged(newValue);
            }
        }
    }
}
