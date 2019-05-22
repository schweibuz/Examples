package com.company.work.Extend.Peoples;

/**
 * Created by iMac on 08/01/17.
 */
class Politican extends People{
    public Politican(String n, int a, String ss) {
        super(n, a, ss);
    }

    public String Corruption(){
        return null;
    }

    @Override
    public void say() {     //полиморфизм есть переопределение метода (@Override)
        System.out.println("Hello World!!!!");
    }
}
