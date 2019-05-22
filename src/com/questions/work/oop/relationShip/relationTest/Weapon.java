package com.questions.work.oop.relationShip.relationTest;

/**
 * Created by iMac on 27/10/2017.
 */
class Weapon {
    private String weapon;

    public Weapon(String weapon) {
        this.weapon = weapon;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return weapon;
    }
}
