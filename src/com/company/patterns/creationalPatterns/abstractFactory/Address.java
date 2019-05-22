package com.company.patterns.creationalPatterns.abstractFactory;

abstract class Address {
    private String street;
    private String city;
    private String region;
    private String postalCode;

    static final String EOL_STRING = System.getProperty("line.separator");
    static final String SPACE = " ";

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public abstract String getCountry();

    public String getFullAddress() {
        return street + EOL_STRING + city + SPACE + postalCode + EOL_STRING;
    }

    public void setStreet(String newStreet) {
        this.street = newStreet;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    public void setRegion(String newRegion) {
        this.region = newRegion;
    }

    public void setPostalCode(String newPostalCode) {
        this.postalCode = newPostalCode;
    }
}
