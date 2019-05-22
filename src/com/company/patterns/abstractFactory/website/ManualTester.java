package com.company.patterns.abstractFactory.website;

import com.company.patterns.abstractFactory.Tester;

class ManualTester implements Tester {
    @Override
    public void testCode() {
        System.out.println("Manual tester tests website...");
    }
}
