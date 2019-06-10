package com.spring2019.interviewQuestions.core.serialization.externalizable;

import java.io.*;

class Person implements Externalizable {

    transient private int id;
    private String name;
    private String gender;

    public Person() {
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeObject(name + "xyz");
        out.writeObject("abc" + gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readInt();
        name = (String) in.readObject();
        if (!name.endsWith("xyz")) throw new IOException("corrupted data");
        name = name.substring(0, name.length() - 3);
        gender = (String) in.readObject();
        if (!gender.startsWith("abc")) throw new IOException("corrupted data");
        gender = gender.substring(3);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
