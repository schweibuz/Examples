package com.company.classRelationship;

class Aggregation2 {
    public static void main(String args[]) {
        MegaOfficeSuiteDVD dvd = new MegaOfficeSuiteDVD();
        Computerr c = new Computerr(dvd);
        System.out.println("\nBrowsing the internet...");
        System.out.println("Writing check source code...");
        c.dvdStuff();
        System.out.println("Saving work...\n");
        c.allDone();
        c = null;  // The computer object and all the composition objects are destroyed and eligible for garbage collection
        dvd.viewShinySurface(); // it's alive!

    }
}

class OperatingSystem2 {
    void bootUp() {
        System.out.println("OS is booting up");
    }

    void shutDown() {
        System.out.println("OS is shutting down");
    }
}

class PowerSupply2 {
    void turnOn() {
        System.out.println("Powering on");
    }

    void turnOff() {
        System.out.println("Powering off");
    }
}

class DVDDrive {
    void open() {
        System.out.println("DVD drive is open");
    }

    void close() {
        System.out.println("DVD drive is closed");
    }
}

class MegaOfficeSuiteDVD {
    void installSoftware() {
        System.out.println("Installation of Mega Office Suite complete!");
    }

    void viewShinySurface() {
        System.out.println("\nJust look at that shiny prismy reflection ...");
    }
}

class Computerr {
    private OperatingSystem2 os = new OperatingSystem2(); // composition
    private PowerSupply2 ps = new PowerSupply2(); // composition
    private DVDDrive drive = new DVDDrive(); // composition
    private MegaOfficeSuiteDVD dvd; // reference only - potential for aggregation

    Computerr(MegaOfficeSuiteDVD dvd) {
        this.dvd = dvd; // aggregation
        ps.turnOn();
        os.bootUp();
    }

    void dvdStuff() {
        drive.open();
        System.out.println("Placing DVD in tray...");
        drive.close();
        dvd.installSoftware();
        drive.open();
        System.out.println("Removing DVD from tray...");
        drive.close();
    }

    void allDone() {
        os.shutDown();
        ps.turnOff();
    }
}