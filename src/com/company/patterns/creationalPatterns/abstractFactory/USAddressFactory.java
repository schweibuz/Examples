package com.company.patterns.creationalPatterns.abstractFactory;

class USAddressFactory implements AddressFactory {
    @Override
    public Address createAddress() {
        return new USAddress();
    }

    @Override
    public PhoneNumber createPhoneNumber() {
        return new USPhoneNumber();
    }
}
