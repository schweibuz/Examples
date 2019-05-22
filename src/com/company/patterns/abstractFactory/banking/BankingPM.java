package com.company.patterns.abstractFactory.banking;

import com.company.patterns.abstractFactory.ProjectManager;

class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manager banking project...");
    }
}
