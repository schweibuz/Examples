package com.company.patterns.creationalPatterns.abstractFactory;

interface AddressFactory {
    public Address createAddress();
    public PhoneNumber createPhoneNumber();
}
