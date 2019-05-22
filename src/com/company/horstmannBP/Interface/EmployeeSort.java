package com.company.horstmannBP.Interface;

class EmployeeSort implements Comparable<EmployeeSort>{

    private String name;
    private double salary;

    public EmployeeSort(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public int compareTo(EmployeeSort other) {
        return Double.compare(salary, other.salary);
    }
}
