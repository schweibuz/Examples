package com.company.patterns.abstractFactory.website;

import com.company.patterns.abstractFactory.Developer;

class PhpDeveloper implements Developer {
    @Override
    public void WriteCode() {
        System.out.println("PHP developer writes website...");
    }
}
