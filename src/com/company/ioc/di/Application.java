package com.company.ioc.di;

/**
 * Created by iMac on 04.09.17.
 */

class Application {
    public void myDrawMethod(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        Drawing triangle = new Drawing(new Triangle());
        Drawing circle = new Drawing(new Circle());
        triangle.drawShape();
        circle.drawShape();

        Application app = new Application();
        app.myDrawMethod(new Triangle());
        app.myDrawMethod(new Circle());
    }
}

class Drawing {
    private Shape shape;

    public Drawing(Shape shape) {
        this.shape = shape;
    }

    public void drawShape() {
        this.shape.draw();
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Let's drawing a circle.");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Let's drawing a triangle.");
    }
}

interface Shape {
    void draw();
}