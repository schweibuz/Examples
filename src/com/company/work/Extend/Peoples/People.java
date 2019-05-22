package com.company.work.Extend.Peoples;

/**
 * Created by iMac on 08/01/17.
 */
class People {
    private String name;
    private int age;
    private String sexX;

    public People(String n, int a, String ss) {
        this.name = n;
        this.age = a;
        this.sexX = ss;
        this.forSex("man");
    }

    public boolean forSex(String sexX) {
        if (sexX == "man")
            return true;
        else
            return false;
    }

    public String toString() {
        String st = getName() + " " + getAge() + " " + getSexX();
        return st;
    }

    public void say() {
        System.out.println("Helllo!");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSexX() {
        return sexX;
    }
}
