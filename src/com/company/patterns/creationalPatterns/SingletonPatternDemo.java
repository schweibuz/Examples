package com.company.patterns.creationalPatterns;

class SingletonPatternDemo {
    public static void main(String[] args) {

        SingleObject object = SingleObject.getInstance();
        object.showMessage();
    }
}

class SingleObject {
    private static SingleObject instance = new SingleObject();

    private SingleObject() { }

    static SingleObject getInstance() {
        return instance;
    }

    void showMessage(){
        System.out.println("Hello Wrold");
    }
}