package com.company.work.testProject;

/**
 * Created by iMac on 23.08.17.
 */
class Employee {
    private final int age;
    private final int salary;
    private final String firstName;
    private final String lastName;

    static class Builder {
        private int age = 0;
        private int salary = 0;
        private String firstName;
        private String lastName;

        public Builder age(int val) {
            this.age = val;
            return this;
        }

        public Builder salary(int val) {
            this.salary = val;
            return this;
        }

        public Builder firstName(String name) {
            this.firstName = name;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

    Employee(Builder builder) {
        this.age = builder.age;
        this.salary = builder.salary;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Employee employee = new Builder().age(28).firstName("Andrey").lastName("Macera").salary(40000).build();
        System.out.println(employee);
    }
}
