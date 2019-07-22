package com.from4.interviewQuestions.core.serialization;

class DeserializationTest {
    public static void main(String[] args) {

        String fileName = "/users/andmat/desktop/employees.txt";
        Employee empNew = null;

        empNew = (Employee) SerializationUtil.deserialize(fileName);

        System.out.println("empNew Object:" + empNew);


    }
}
