package com.company.patterns.abstractFactory.banking;

import com.company.patterns.abstractFactory.Developer;
import com.company.patterns.abstractFactory.ProjectManager;
import com.company.patterns.abstractFactory.ProjectTeamFactory;
import com.company.patterns.abstractFactory.Tester;

class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
