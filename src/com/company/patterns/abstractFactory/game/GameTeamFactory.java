package com.company.patterns.abstractFactory.game;

import com.company.patterns.abstractFactory.Developer;
import com.company.patterns.abstractFactory.ProjectManager;
import com.company.patterns.abstractFactory.ProjectTeamFactory;
import com.company.patterns.abstractFactory.Tester;

class GameTeamFactory implements ProjectTeamFactory{
    @Override
    public Developer getDeveloper() {
        return new GameDev();
    }

    @Override
    public Tester getTester() {
        return new Gamer();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new GameTeamLead();
    }
}
