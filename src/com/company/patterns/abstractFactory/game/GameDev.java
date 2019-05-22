package com.company.patterns.abstractFactory.game;

import com.company.patterns.abstractFactory.Developer;

class GameDev implements Developer {
    @Override
    public void WriteCode() {
        System.out.println("Game Developer writes Game...");
    }
}
