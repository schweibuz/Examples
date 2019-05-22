package com.company.classRelationship.auto;

class Sedan extends Automobile{
    private boolean allRoad;

    Sedan(IEngine eng, String name, String color, int cost, boolean allRoad) {
        super(name, color, cost, eng);
        this.allRoad = allRoad;
    }
}
