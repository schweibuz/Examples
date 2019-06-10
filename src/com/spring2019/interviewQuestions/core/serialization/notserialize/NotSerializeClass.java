package com.spring2019.interviewQuestions.core.serialization.notserialize;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

class NotSerializeClass extends SerializableSuperClass {

    private String model;
    private int cost;
    transient private int discount;

    public NotSerializeClass() {
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        throw  new NotSerializableException("Not today!");
    }

    private void readObject(ObjectInputStream in) throws IOException {
        throw  new NotSerializableException("Not today!");
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        throw new NotSerializableException("Not today");
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        throw new NotSerializableException("Not today");
//    }

    public String getModel() {
        return model;
    }

    public int getCost() {
        return cost;
    }

    public int getDiscount() {
        return discount;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "NotSerializeClass{" +
                "model='" + model + '\'' +
                ", cost=" + cost +
                ", discount=" + discount +
                '}';
    }
}
