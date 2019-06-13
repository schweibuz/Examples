package com.spring2019.interviewQuestions.core.relationship.constructor;

class CopyConstructor {

    int id;
    String mark;

    CopyConstructor(int i, String m) {
        this.id = i;
        this.mark = m;
    }

    CopyConstructor() {}

    CopyConstructor(CopyConstructor copy) {
        this.id = copy.id;
        this.mark = copy.mark;
    }

    void display() {
        System.out.println(id + " " + mark);
    }

    public static void main(String[] args) {

        CopyConstructor entity = new CopyConstructor(1, "BMW");
        CopyConstructor copy = new CopyConstructor(entity);
        CopyConstructor copyWithoutConstructor = new CopyConstructor();

        entity.display();
        copy.display();

        copyWithoutConstructor.id = copy.id;
        copyWithoutConstructor.mark = copy.mark;

        copyWithoutConstructor.display();

    }
}