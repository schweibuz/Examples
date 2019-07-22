package com.from4.interviewQuestions.core.serialization.notserialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class NotSerializeDemo {
    public static void main(String[] args) {

        String fileName = "/users/andmat/desktop/person.ser";
        SerializableSuperClass supCl = new SerializableSuperClass();
        supCl.setName("Hoff");
        supCl.setAge(13);
        supCl.setFree(true);

        serialize(supCl, fileName);
        System.out.println(deserialize(fileName).toString());

        NotSerializeClass notSer = new NotSerializeClass();
        notSer.setModel("Cannondale");
        notSer.setCost(300);
        notSer.setDiscount(50);

        serialize(notSer, fileName);
        System.out.println(deserialize(fileName).toString());
    }

    public static void serialize(Object obj, String fileName) {

        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
            System.out.println("Write object:" + obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object deserialize(String fileNmae) {

        Object obj = null;
        try (FileInputStream fis = new FileInputStream(fileNmae);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
