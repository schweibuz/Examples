package com.questions.work.oop.relationShip.relationTest;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by iMac on 27/10/2017.
 */
class Country {
    private String country;
    private Set citizens = new HashSet();

    public Country(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addCitizen(Man newMan) {
        citizens.add(newMan);
        newMan.setCountry(this);
    }

    public Set getCitizens() {
        return citizens;
    }

    public void setCitizens(Set citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return country;
    }
}
