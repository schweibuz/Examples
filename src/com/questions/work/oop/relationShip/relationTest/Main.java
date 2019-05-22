package com.questions.work.oop.relationShip.relationTest;

import java.util.Iterator;

/**
 * Created by iMac on 27/10/2017.
 */
class Main {
    public static void main(String[] args) {
        Man warrior = new Man(187, 29, "Hew", "Warrior");
        Weapon AK47 = new Weapon("AK-47");
        warrior.setWeapon(AK47);

        Country germany = new Country("Deutschland");
        Country russia = new Country("Russia");
        warrior.setCountry(germany);

        PastRole warriorPatRole = new PastRole(warrior.getRole(), warrior.getCountry());
        warrior.setPastRoles(warriorPatRole);
        warrior.setRole("Child");
        warrior.setCountry(russia);
        String s = (warrior.getName() + " lives in " + warrior.getCountry() + ", him " +
                warrior.getAge() + " years old" + ", he tall - " + warrior.getHigh() + " sm" +
                " and has an " + warrior.getWeapon() + ", he is a " + warrior.getRole() + ".");
        System.out.println(s);

        Iterator iter = warrior.getPastRoles().iterator();
        System.out.println("Before he was " + iter.next());

    }
}
