package com.questions.work.oop.relationShip.relationTest;

/**
 * Created by iMac on 27/10/2017.
 */
class PastRole {
    private String role;
    private Country country;

    public PastRole(String role, Country country) {
        this.role = role;
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\"" + role + ", country=" + country + "\"";
    }
}
