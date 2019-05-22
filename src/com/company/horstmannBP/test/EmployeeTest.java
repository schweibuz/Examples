package com.company.horstmannBP.test;

import java.text.NumberFormat;
import java.util.Date;
import java.util.GregorianCalendar;

class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[4];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
        staff[3] = new Employee("Harry Stamper", 30000, 2000, 2,1);

        for (Employee e : staff) {
            e.setId();
            e.raiseSalary(5);
        }

        Employee.tripleSalary(staff[3]);

        for (Employee e : staff) {
            System.out.println("id:" + e.getId() + ", name=" + e.getName() + ", salary=" + e.getSalary() +
                    ", hireDay=" + e.getHireDay());
        }

        Employee boss = new Employee("Boss");
        Employee kross = new Employee("Kross");
        Employee beach = new Employee("Harley Quinn", 4000, 2017, 01, 6, 19, 30);

        System.out.println("\n" + boss.equals(kross));    //Метод может обращаться к закрытым данным всех объектов своего класса!
        System.out.println(staff[0].getName().equals(staff[0].getName()));
        System.out.println(staff[3].getName() + " - " + beach.getName() + " будет вас ждать " + beach.getRelaxDate() + " и будет вам стоить "
                + beach.getSalary() + " рублей");

        boss.setId();   //присваимваем поле класса id объектам класса
        kross.setId();
        staff[1].setId();
        int n = Employee.getNextId();   //вызов статического метода. Статический метод не оперирует объектами
        System.out.println(boss.getId() + " " + kross.getId() + " " + staff[1].getId() + " " + n);

        NumberFormat currentFormatter = NumberFormat.getCurrencyInstance();     //Фабричные методы для создания объектов,
        NumberFormat percentFormatter = NumberFormat.getPercentInstance();      //соотв.различным стилям форматирования.
        System.out.println(currentFormatter.format(boss.getX()));
        System.out.println(percentFormatter.format(boss.getX()));
    }
}

class Employee {

    private final String name;  //объявили неизменяемым посколку после создания объекта оно уже не изменяется
    private double salary;
    private Date hireDay;
    private Date relaxDate;
    private double x = 0.1;
    private static int nextId = 1; //static поле - это поле класса. Принадлежит всем объектам класса. Только 1 экземпляо.
    private int id;

    public Employee(String n) {
        name = n;
    }

    public Employee(String n, double cost, int year, int month, int day, int hour, int minutes) {
        name = n;
        salary = cost;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day, hour, minutes, minutes);
        relaxDate = calendar.getTime();
    }

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        hireDay = calendar.getTime();
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return (Date) hireDay.clone();  //В качестве эмпирического правила пользоваться методом CLONE
    }                                   //если нужно скопировать изменяемое поле данных(тк ссылка на изменяемый объект)

    public Date getRelaxDate() {
        return (Date) relaxDate.clone();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        id = nextId;
        nextId++;
    }

    public static int getNextId() {     //static методы создаём в двух случаях: 1.Когда не требуется доступ к данным о состоянии объекта,
        return nextId;                  //параметры задяются явно(пример - Math.pow()). 2.Когда треюуется доступ лишь к статическим полям класса.
    }

    public void raiseSalary(double byPercent) {     //Метод имеет доступ к закрытым данным того объекта для которого вызывается
        double raise = this.salary * byPercent / 100;    //но он также может обращаться к закрытым данным всех объектов своего класса.
        salary += raise;
    }

    private boolean equals(Employee other) {
        return name.equals(other.name);
    }

    public double getX() {
        return x;
    }

    public static void tripleSalary(Employee x) {
        x.raiseSalary(200);
    }

//    public static void main(String[] args) {
//        Employee e = new Employee("Romeo", 50000, 2003, 3, 31);
//        e.raiseSalary(20);
//        e.setId();
//        System.out.println(e.getModel() + " id:" + e.getNextId() + " заработаная плата:" + e.getSalary());
//    }
}

//class Testik {
//    private int addition;
//    private double adHead;
//    private String additionName;
//
//    public Testik(double a) {
//        adHead = a;
//    }
//    public Testik(int a, String b) {
//        addition = a;
//        additionName = b;
//    }
//
//    public int getAddition() {
//        return addition;
//    }
//
//    public String getAdditionName() {
//        return additionName;
//    }
//}

