package com.company.horstmannBP.Interface;

class EmployeeSortTest {
    public static void main(String[] args) {
        EmployeeSort[] staff = new EmployeeSort[3];
        staff[0] = new EmployeeSort("Carl Cracker", 75000);
        staff[1] = new EmployeeSort("Harry Hacker", 150000);
        staff[2] = new EmployeeSort("Tony Tester", 40000);

        java.util.Arrays.sort(staff);

        for (int i = 0; i < staff.length; i++) {
            int f = staff[i].compareTo(staff[0]);
            if (f == 0) {
                System.out.println("Equals to");
            } else if (f == 1) {
                System.out.println("Greater than");
            } else {
                System.out.println("Less than");
            }
        }

        for (int i = 0; i < staff.length; i++) {
            staff[i].raiseSalary(50);
        }

        for (EmployeeSort e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }

    }
}
