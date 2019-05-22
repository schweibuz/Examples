package com.company.patterns.abstractFactory.website;

import com.company.patterns.abstractFactory.ProjectManager;

class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages Website project...");
    }
}
