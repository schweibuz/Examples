package com.company.patterns.creationalPatterns.abstractFactory;

class FactoryMain {
    AddressFactory usaF = new USAddressFactory();
    AddressFactory frF = new FrenchAddressFactory();
    USAddress usAddress = new USAddress();

    public static void main(String[] args) {
        System.out.println("Heelloo");
        FactoryMain facMain = new FactoryMain();
        facMain.usaF.createAddress().setStreet("Dachniy prospect");
        System.out.println(facMain.usAddress.getFullAddress());
//        System.out.println(facMain.usaF.createPhoneNumber().getCountryCode());
//        System.out.println(facMain.usaF.createPhoneNumber().getPhoneNumber());
//        System.out.println(facMain.usaF.createAddress().getFullAddress());
    }
}
