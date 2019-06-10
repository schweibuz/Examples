package com.spring2019.interviewQuestions.core.serialization.notserialize;

import java.io.Serializable;

class SerializableSuperClass implements Serializable {

    private String name;
    private int age;
    transient private boolean free;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isFree() {
        return free;
    }

    @Override
    public String toString() {
        return "SerializableSuperClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", free=" + free +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
