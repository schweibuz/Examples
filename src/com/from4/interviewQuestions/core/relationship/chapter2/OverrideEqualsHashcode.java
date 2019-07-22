package com.from4.interviewQuestions.core.relationship.chapter2;

import java.util.*;

class OverrideEqualsHashcode {
    public static void main(String[] args) {
        Student vas = new Student("Vas", 32);
        Student pet = new Student("Pet", 33);
        OverrideEqualsHashcode vas1 = new OverrideEqualsHashcode(vas);
        OverrideEqualsHashcode pet1 = new OverrideEqualsHashcode(pet);
        Student neoVas = new Student("as", 32);
        Student neoPet = new Student("Pet", 33);
        neoVas = vas;

        System.out.printf("%s %s\n", pet.hashCode(), vas.hashCode());
        System.out.printf("%s %s\n\n", neoPet.hashCode(), neoVas.hashCode());



        Iterator iter = map.entrySet().iterator();
        System.out.println("map size: " + map.size());
        while (iter.hasNext()) {
            System.out.println(iter.next().hashCode());
        }
        System.out.println("map contains " + map.containsValue(neoVas));
        System.out.println("map contains " + map.containsValue(neoPet));



        Iterator iter2 = set.iterator();
        System.out.println("\nset size: " + set.size());
        while (iter2.hasNext()) {
            System.out.println(iter2.next().hashCode());
        }
        System.out.println("set contains " + set.contains(neoVas));
        System.out.println("set contains " + set.contains(neoPet));



        Iterator iter3 = table.entrySet().iterator();
        System.out.println("\ntable size: " + table.size());
        while (iter3.hasNext()) {
            System.out.println(iter3.next().hashCode());
        }
        System.out.println("table contains " + table.containsValue(neoVas));
        System.out.println("table contains " + table.containsValue(neoPet));

    }


    static Set<Student> set = new HashSet<>();
    static Map map = new HashMap();
    static Map table = new Hashtable();
    static int count = 0;

    OverrideEqualsHashcode(Student student) {
        set.add(student);
        map.put(count, student);
        table.put(count, student);
        count++;
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this == null || getClass() != o.getClass()) return false;
//        if (!(o instanceof OverrideEqualsHashcode)) return false; //instanceOf check subclasses, interfaces
        Student tmp = (Student) o;
        return this.name == tmp.name && this.age == tmp.age;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = result * 31 + age;
        return result;
    }
}
