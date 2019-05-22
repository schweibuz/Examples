package com.company.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by iMac on 15.08.17.
 */
class Test2 {
}

class parent implements Serializable {
    int parentVersion = 10;
}

class contain implements Serializable{
    int containVersion = 11;
}
class SerialTest extends parent implements Serializable {
    int version = 66;
    contain con = new contain();

    public int getVersion() {
        return version;
    }
    public static void main(String args[]) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/iMac/Desktop/Stopi/Test2");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        SerialTest st = new SerialTest();
        oos.writeObject(st);
        oos.flush();
        oos.close();
    }
}