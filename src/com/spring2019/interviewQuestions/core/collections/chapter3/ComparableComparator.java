package com.spring2019.interviewQuestions.core.collections.chapter3;

import java.util.*;

class ComparableComparator {
    public static void main(String[] args) {
        int[] mas = {1, 3, 6, 1, 2, 3, 4};
        Arrays.sort(mas);
        System.out.println(Arrays.toString(mas));

        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("S");
        strList.add("E");
        strList.add("G");
        strList.add("R");
        Collections.sort(strList);
        for (String str : strList)
            System.out.print(str + " ");

        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);

        Arrays.sort(empArr);
        System.out.println("\n" + Arrays.toString(empArr) + "\n");

        //sort employees array using Comparator by Salary
        Arrays.sort(empArr, Employee.SalaryComparator);
        System.out.println("Employees list sorted by Salary:\n" + Arrays.toString(empArr) + "\n");

        //sort employees array using Comparator by Age
        Arrays.sort(empArr, Employee.AgeComparator);
        System.out.println("Employees list sorted by Age:\n" + Arrays.toString(empArr) + "\n");

        //sort employees array using Comparator by Name
        Arrays.sort(empArr, Employee.NameComparator);
        System.out.println("Employees list sorted by Name:\n" + Arrays.toString(empArr) + "\n");

        //Employees list sorted by ID and then name using Comparator class
        empArr[0] = new Employee(1, "Mikey", 25, 10000);
        Arrays.sort(empArr, new EmployeeComparatorByIdAndName());
        System.out.println("Employees list sorted by ID and Name:\n"+Arrays.toString(empArr));
    }

    static class EmployeeComparatorByIdAndName implements Comparator<Employee> {

        @Override
        public int compare(Employee o1, Employee o2) {
            int flag = o1.id - o2.id;
            if (flag == 0) flag = o1.getName().compareTo(o2.getName());
            return flag;
        }
    }

    static class Employee implements Comparable<Employee> {

        private int id;
        private String name;
        private int age;
        private long salary;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public long getSalary() {
            return salary;
        }

        Employee(int id, String name, int age, int salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "[id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +"]";
        }

        @Override
        public int compareTo(Employee o) {
            return (this.id - o.id);
        }

        public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return (int) (o1.getSalary() - o2.getSalary());
            }
        };

        public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        };

        public static Comparator<Employee> NameComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
    }
}
