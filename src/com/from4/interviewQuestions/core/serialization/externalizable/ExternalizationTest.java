package com.from4.interviewQuestions.core.serialization.externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class ExternalizationTest {
    public static void main(String[] args) {

        String fileName = "/users/andmat/desktop/person.ser";
        Person person = new Person();
        person.setId(1);
        person.setName("Steve");
        person.setGender("Male");

        serialize(person, fileName);
        deserialize(fileName);

    }

    public static void serialize(Person obj, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            System.out.println("Person=" + obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileName) {
        Object p = null;
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            p = ois.readObject();
            System.out.println("Person Object Read=" + p);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return p;
    }
}