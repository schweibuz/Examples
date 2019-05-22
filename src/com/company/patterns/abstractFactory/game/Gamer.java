package com.company.patterns.abstractFactory.game;

import com.company.patterns.abstractFactory.Tester;

class Gamer implements Tester {
    @Override
    public void testCode() {
        System.out.println("Gamer play the game and stack the code...");
    }
}
