package com.questions.tasks.proglib;

/**
 * Created by iMac on 19/11/2017.
 */
class EqHashT {
    public static void main(String[] args) {
        Employee manager1 = new Employee("Vasya", 1);
        Employee manager2 = new Employee("Petya", 2);
        Employee manager3 = new Employee("Vasya", 3);
        Employee manager4 = new Employee("Stepan", 4);
        Employee manager5 = new Employee("Stepan", 4);
        Employee2 neoManager = new Employee2("Stepan", 4);

        System.out.printf("%s and %s", manager1, manager2 + " = " + manager1.equals(manager2) + "\n");
        System.out.printf("%s and %s", manager2, manager3 + " = " + manager2.equals(manager3) + "\n");
        System.out.printf("%s and %s", manager1, manager3 + " = " + manager1.equals(manager3) + "\n");
        System.out.printf("%s and %s", manager4, manager4 + " = " + manager4.equals(manager4) + "\n");
        System.out.printf("%s and %s", manager4, manager5 + " = " + manager4.equals(manager5) + "\n");
        System.out.printf("%s and %s", neoManager, manager5 + " = " + neoManager.equals(manager5) + "\n");
        System.out.printf("%s and %s", neoManager, "null" + " = " + neoManager.equals(null) + "\n");

        System.out.println(manager1.equals(manager2) ? 0 : 1);
        System.out.println(manager5.equals(neoManager));
    }
}

class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "(" + name +
                ", id=" + id + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }
}


class Employee2 {
    private String name;
    private int id;

    Employee2(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "(" + name +
                ", id=" + id + ")";
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || o.getClass() != this.getClass())
            return false;
        Employee2 employee2 = (Employee2) o;
        if (id != employee2.id)
            return false;
        return name != null ? name == employee2.name : employee2.name == null;
    }
}