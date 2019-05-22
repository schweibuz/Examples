package com.questions.work.oop.relationShip.relationTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by iMac on 27/10/2017.
 */
class Human {
    protected int high;
    protected int age;
    protected String name;

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "high='" + high +
                ", age=" + age;
    }
}

class Man extends Human {
    private String role;
    private Weapon weapon;      //ASSOCIATE
    private Country country;        //AGGREGATE
    private Set<PastRole> pastRoles = new HashSet();

    public Man(int high, int age, String name, String role) {
        this.high = high;
        this.age = age;
        this.name = name;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<PastRole> getPastRoles() {
        return pastRoles;
    }

    public void setPastRoles(PastRole pastRoles) {
        this.pastRoles.add(pastRoles);
    }

    public void deletePastRoles(PastRole pastRole) {
        this.pastRoles.remove(pastRole);
    }
}
