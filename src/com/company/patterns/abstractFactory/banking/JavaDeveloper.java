package com.company.patterns.abstractFactory.banking;

import com.company.patterns.abstractFactory.Developer;

class JavaDeveloper implements Developer {
    @Override
    public void WriteCode() {
        System.out.println("Java developer writes Java code...");
    }
}
