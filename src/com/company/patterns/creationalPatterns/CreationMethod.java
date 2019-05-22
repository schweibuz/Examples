package com.company.patterns.creationalPatterns;

class CreationMethod {
    public static void main(String[] args) {
        creationMethod("WORLD");
    }

    private String value = "HELLO";

    private CreationMethod(String value) {
        System.out.println(this.value + " " + value);
    }

    static CreationMethod creationMethod(String value) {
        return new CreationMethod(value);
    }
}
