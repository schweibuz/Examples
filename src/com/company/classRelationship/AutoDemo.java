package com.company.classRelationship;

/**
 * Created by iMac on 18.08.17.
 * Aggregation
 */
class AutoDemo {
    public static void main(String[] args) {
        System.out.println(new Car("Chrisler", "2J343K1", new Engine(true, 4)));
    }
}

class Car {
    private String model;
    private String ViN;
    private Engine engine;

    public Car() {}

    public Car(String model, String ViN, Engine engine) {
        this.model = model;
        this.ViN = ViN;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", ViN=" + ViN +
                ", engine= " + engine +
                '}';
    }
}

class Engine {
    private boolean turbo;
    private int engineCapacity;

    public Engine() {}

    public Engine(boolean turbo, int engineCapacity) {
        this.turbo = turbo;
        this.engineCapacity = engineCapacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "turbo=" + turbo +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
