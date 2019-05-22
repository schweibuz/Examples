package com.company.patterns.abstractFactory.website;

import com.company.patterns.abstractFactory.Developer;
import com.company.patterns.abstractFactory.ProjectManager;
import com.company.patterns.abstractFactory.ProjectTeamFactory;
import com.company.patterns.abstractFactory.Tester;

class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}