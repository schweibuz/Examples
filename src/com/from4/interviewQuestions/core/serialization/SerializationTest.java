package com.from4.interviewQuestions.core.serialization;

class SerializationTest {
    public static void main(String[] args) {

        String fileName = "/users/andmat/desktop/employees.txt";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Jack");
        emp.setSalary(6000);

        SerializationUtil.serialize(emp, fileName);

        Employee empNew = (Employee) SerializationUtil.deserialize(fileName);

        System.out.println("emp object:" + emp);
        System.out.println("empNew object:" + empNew);

    }
}
