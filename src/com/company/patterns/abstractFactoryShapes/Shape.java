package com.company.patterns.abstractFactoryShapes;

class Demo {
//Use the FactoryProducer to get AbstractFactory in order to get factories of concrete classes by passing an information such as type.
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        Shape shape1 = shapeFactory.getShape("ciRcle");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RecTangle");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("SquaRE");
        shape3.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOr");
        Colors color1 = colorFactory.getColor("RED");
        color1.fill();
        Colors color2 = colorFactory.getColor("BluE");
        color2.fill();
        Colors color3 = colorFactory.getColor("gREEN");
        color3.fill();
    }
}

//7Create a Factory generator/producer class to get factories by passing an information such as Shape or Color
class FactoryProducer {
    static AbstractFactory getFactory(String choice){

        if(choice.equalsIgnoreCase("shape")){
            return new ShapeFactory();
        }else if(choice.equalsIgnoreCase("Color")){
            return new ColorFactory();
        }

        return null;
    }
}
//5Create an Abstract class to get factories for Color and Shape Objects.
abstract class AbstractFactory {
    abstract Colors getColor(String color);
    abstract Shape getShape(String shape);
}
//6Create Factory classes extending AbstractFactory to generate object of concrete class based on given information.
class ShapeFactory extends AbstractFactory {

    @Override
    Colors getColor(String color) {
        return null;
    }

    @Override
    Shape getShape(String shapeType) {

        if(shapeType == null){
            return null;
        }

        if (shapeType.equalsIgnoreCase("circle")){
            return new Circle();
        }else if(shapeType.equalsIgnoreCase("rectangle")){
            return new Rectangle();
        }else if(shapeType.equalsIgnoreCase("square")){
            return new Square();
        }

        return null;
    }
}

class ColorFactory extends AbstractFactory {

    @Override
    Colors getColor(String color) {
        if(color == null){
            return null;
        }

        if(color.equalsIgnoreCase("red")){
            return new Red();
        }else if(color.equalsIgnoreCase("green")){
            return new Green();
        }else if(color.equalsIgnoreCase("Blue")){
            return new Blue();
        }

        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

interface Colors {
    void fill();
}

class Red implements Colors {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}

class Green implements Colors {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}

class Blue implements Colors {

    @Override
    public void fill() {
        System.out.println("Inside BLue::fill() method.");
    }
}