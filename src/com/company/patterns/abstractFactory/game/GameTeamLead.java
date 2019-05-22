package com.company.patterns.abstractFactory.game;

import com.company.patterns.abstractFactory.ProjectManager;

class GameTeamLead implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Game manager manage game...");
    }
}
