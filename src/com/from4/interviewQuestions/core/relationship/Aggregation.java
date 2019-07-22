package com.from4.interviewQuestions.core.relationship;

class Aggregation {
    public static void main(String[] args) {
        Pension pension = new Pension();
        Aggregation aggregation = new Aggregation(pension);
        System.out.println(aggregation.toString());
        aggregation = null;
        try {
            System.out.println(aggregation.toString());
        } catch (NullPointerException e) {
            System.out.println("nuli");;
        }
        System.out.println(pension.toString());
    }

    Employee employee = new Employee();
    Work work = new Work();
    Pension pension;

    Aggregation(Pension pension) {
        this.pension = pension;
        employee.doSomething();
        work.doSomething();
    }

    @Override
    public String toString() {
        return "Aggregation{" +
                "employee=" + employee +
                ", work=" + work +
                ", pension=" + pension +
                '}';
    }
}

class Employee {
    public void doSomething() {
        System.out.println("I'm employee");
    }

    @Override
    public String toString() {
        return "Employee{}";
    }
}

class Work {
    public void doSomething() {
        System.out.println("I'm work");
    }

    @Override
    public String toString() {
        return "Work{}";
    }
}

class Pension {
    public void doSomething() {
        System.out.println("I'm pension");
    }

    @Override
    public String toString() {
        return "Pension{}";
    }
}
