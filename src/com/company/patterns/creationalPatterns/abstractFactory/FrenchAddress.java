package com.company.patterns.creationalPatterns.abstractFactory;

class FrenchAddress extends Address{
    private static final String CONTRY = "FRANCE";

    @Override
    public String getCountry() {
        return CONTRY;
    }

    public String getFullAddress() {
        return getStreet() + EOL_STRING + getPostalCode() + SPACE +
                getCity() + EOL_STRING + CONTRY + EOL_STRING;
    }
}
