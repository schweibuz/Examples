package com.company.classRelationship.auto;

class GasolineEngine implements IEngine {
    private int power;
    private int cylinders;

    public GasolineEngine(int power, int cylinders) {
        this.power = power;
        this.cylinders = cylinders;
    }

    public int getPower() throws Exception {
        if (power <= 0) {
            throw new Exception("exception: " + power);
        }
        return power / 2 * cylinders;
    }
}
class ElectricEngine implements IEngine {
    private int power;
    private int KW;

    public ElectricEngine(int power, int KW) {
        this.power = power;
        this.KW = KW;
    }

    public int getPower() throws Exception {
        if (power <= 0) {
            throw new Exception("exception: " + power);
        }
        return power / 2 * KW;

    }
}