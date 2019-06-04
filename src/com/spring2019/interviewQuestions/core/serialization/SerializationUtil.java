package com.spring2019.interviewQuestions.core.serialization;

import java.io.*;

class SerializationUtil {

    public static Object deserialize(String filename) {
        Object obj = null;
        try (InputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static void serialize(Object obj, String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
