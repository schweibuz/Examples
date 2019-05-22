package com.company.classRelationship.auto;

class Jeep extends Automobile{
    private boolean allRoad;

    Jeep(IEngine eng, String name, String color, int cost, boolean allRoad) {
        super(name, color, cost, eng);
        this.allRoad = allRoad;
    }
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
