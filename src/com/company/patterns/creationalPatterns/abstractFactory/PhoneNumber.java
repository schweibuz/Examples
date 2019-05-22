package com.company.patterns.creationalPatterns.abstractFactory;

abstract class PhoneNumber {
    private String phoneNumber;
    public abstract String getCountryCode();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String newNumber) {
        try {
            Long.parseLong(newNumber);
        this.phoneNumber = phoneNumber;
        }
        catch (NumberFormatException exc) {
        }
    }
}
