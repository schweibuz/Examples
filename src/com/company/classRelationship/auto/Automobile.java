package com.company.classRelationship.auto;

class Automobile implements Comparable {     //определение правильного порядка двух объектов(comparable)
    private IEngine iEngine;
    private String name;
    private String color;
    private int cost;

    Automobile(String name, String color, int cost, IEngine iEngine) {
        this.name = name;
        this.color = color;
        this.cost = cost;
        this.iEngine = iEngine;
    }

    double calcTax(int iEngine) {
        double tax;
        tax = iEngine / 50;
        if (tax <= 0) {
            return 0;
        } else if (tax <= 1) {
            return iEngine * 24;
        } else if (tax <= 2) {
            return iEngine * 35;
        } else if (tax <= 3) {
            return iEngine * 50;
        } else if (tax <= 4) {
            return iEngine * 75;
        } else return iEngine * 150;
    }

    public String toString() {
        try {
            return this.name + "\ncolor - " + this.color + " | price: " + this.cost + " | Max speed: " + this.iEngine.getPower();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    IEngine getiEngine() {
        return iEngine;
    }

    public int compareTo(Object o) {    //перегруженный метод для реализации класса сортирвоки Comparable
        Automobile anotherAutomibile = (Automobile) o;
//        Automobile automobile = this;
        // вернуть 1 если по порядку
        // 0 если равны
        // - 1 если не по порядку
        try {
            return Integer.compare(iEngine.getPower(), anotherAutomibile.getiEngine().getPower());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}

